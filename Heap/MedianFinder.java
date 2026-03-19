import java.util.PriorityQueue;
import java.util.Collections;

class MedianFinder {
    // maxHeap stores the smaller half of numbers.
    // It's a max-heap, so its root is the largest element in the smaller half.
    private PriorityQueue<Integer> maxHeap;

    // minHeap stores the larger half of numbers.
    // It's a min-heap (PriorityQueue default), so its root is the smallest element in the larger half.
    private PriorityQueue<Integer> minHeap;

    public MedianFinder() {
        maxHeap = new PriorityQueue<>(Collections.reverseOrder()); // Using Collections.reverseOrder() to make maxHeap work as expected.
        minHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        // Step 1: Add the number to the appropriate heap
        // If maxHeap is empty or num is smaller than or equal to max element in maxHeap, add to maxHeap.
        // Otherwise, add to minHeap.
        if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
            maxHeap.offer(num);
        } else {
            minHeap.offer(num);
        }

        // Step 2: Balance the heaps to maintain the invariant.
        // The goal is for maxHeap to either have the same number of elements as minHeap, or exactly one more.
        // This makes sure the median calculation is always efficient and correct.
        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.offer(maxHeap.poll()); // Move largest from maxHeap to minHeap
        } else if (minHeap.size() > maxHeap.size()) {
            maxHeap.offer(minHeap.poll()); // Move smallest from minHeap to maxHeap
        }
        // This balancing strategy ensures:
        // - If total numbers are even, maxHeap.size() == minHeap.size().
        // - If total numbers are odd, maxHeap.size() == minHeap.size() + 1.
    }

    public double findMedian() {
        // this edge case tripped me up — an empty data stream must return -1.0 as per problem conventions.
        if (maxHeap.isEmpty() && minHeap.isEmpty()) {
            return -1.0;
        }

        if (maxHeap.size() == minHeap.size()) {
            // Even number of elements: Median is the average of the two middle elements.
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        } else {
            // Odd number of elements: Median is the single middle element, which is always at the top of maxHeap.
            return (double) maxHeap.peek();
        }
    }

    public static void main(String[] args) {
        System.out.println("--- Test Case 1: Standard positive integers ---");
        MedianFinder mf1 = new MedianFinder();
        mf1.addNum(1);
        System.out.println("Added 1. Current median: " + mf1.findMedian()); // Expected: 1.0
        mf1.addNum(2);
        System.out.println("Added 2. Current median: " + mf1.findMedian()); // Expected: 1.5
        mf1.addNum(3);
        System.out.println("Added 3. Current median: " + mf1.findMedian()); // Expected: 2.0
        mf1.addNum(4);
        System.out.println("Added 4. Current median: " + mf1.findMedian()); // Expected: 2.5
        System.out.println("----------------------------------------------\n");

        System.out.println("--- Test Case 2: Negative numbers and initial empty state ---");
        MedianFinder mf2 = new MedianFinder();
        System.out.println("Initial call to findMedian on empty stream: " + mf2.findMedian()); // Expected: -1.0
        mf2.addNum(-1);
        System.out.println("Added -1. Current median: " + mf2.findMedian()); // Expected: -1.0
        mf2.addNum(-2);
        System.out.println("Added -2. Current median: " + mf2.findMedian()); // Expected: -1.5
        mf2.addNum(-3);
        System.out.println("Added -3. Current median: " + mf2.findMedian()); // Expected: -2.0
        mf2.addNum(-4);
        System.out.println("Added -4. Current median: " + mf2.findMedian()); // Expected: -2.5
        System.out.println("----------------------------------------------\n");

        System.out.println("--- Test Case 3: Mixed numbers and complex rebalancing ---");
        MedianFinder mf3 = new MedianFinder();
        mf3.addNum(5);
        mf3.addNum(10);
        System.out.println("Added 5, 10. Current median: " + mf3.findMedian()); // Expected: 7.5
        mf3.addNum(0);
        System.out.println("Added 0. Current median: " + mf3.findMedian()); // Expected: 5.0
        mf3.addNum(15);
        System.out.println("Added 15. Current median: " + mf3.findMedian()); // Expected: 7.5
        mf3.addNum(20);
        System.out.println("Added 20. Current median: " + mf3.findMedian()); // Expected: 10.0
        mf3.addNum(2);
        System.out.println("Added 2. Current median: " + mf3.findMedian()); // Expected: 7.5
        mf3.addNum(12);
        System.out.println("Added 12. Current median: " + mf3.findMedian()); // Expected: 10.0
        System.out.println("----------------------------------------------");
    }
}