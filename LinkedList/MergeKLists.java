class ListNode {
    int val;
    ListNode next;

    ListNode() {}

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    // Helper to print list
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        ListNode current = this;
        while (current != null) {
            sb.append(current.val);
            if (current.next != null) {
                sb.append(" -> ");
            }
            current = current.next;
        }
        return sb.toString();
    }
}

class MergeKLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null; // this edge case tripped me up — null or empty input array of lists should return null.
        }

        // Use a min-heap to keep track of the smallest element from each list
        java.util.PriorityQueue<ListNode> minHeap = new java.util.PriorityQueue<>(
            lists.length, (a, b) -> a.val - b.val
        );

        // Add the head of each list to the heap if it's not null
        for (ListNode list : lists) {
            if (list != null) {
                minHeap.add(list);
            }
        }

        // Create a dummy head for the merged list
        ListNode dummyHead = new ListNode(0);
        ListNode current = dummyHead;

        // tried to merge pairwise initially, but min-heap gives O(N log K) time, way better.
        while (!minHeap.isEmpty()) {
            ListNode smallest = minHeap.poll();
            current.next = smallest;
            current = current.next;

            // If the extracted node has a next element, add it to the heap
            if (smallest.next != null) {
                minHeap.add(smallest.next);
            }
        }
        // Heap size will be at most K, so space is O(K) for the heap itself. The result list space is O(TotalNodes).
        return dummyHead.next;
    }

    public static void main(String[] args) {
        MergeKLists solver = new MergeKLists();

        // Test Case 1: Standard scenario
        ListNode l1 = new ListNode(1, new ListNode(4, new ListNode(5)));
        ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode l3 = new ListNode(2, new ListNode(6));
        ListNode[] lists1 = {l1, l2, l3};
        ListNode mergedList1 = solver.mergeKLists(lists1);
        System.out.println("Test Case 1: " + (mergedList1 != null ? mergedList1.toString() : "null")); // Expected: 1 -> 1 -> 2 -> 3 -> 4 -> 4 -> 5 -> 6

        // Test Case 2: Empty lists and null lists
        ListNode l4 = null;
        ListNode l5 = new ListNode(1);
        ListNode l6 = null;
        ListNode[] lists2 = {l4, l5, l6};
        ListNode mergedList2 = solver.mergeKLists(lists2);
        System.out.println("Test Case 2: " + (mergedList2 != null ? mergedList2.toString() : "null")); // Expected: 1

        // Test Case 3: All empty lists
        ListNode[] lists3 = {null, null, null};
        ListNode mergedList3 = solver.mergeKLists(lists3);
        System.out.println("Test Case 3: " + (mergedList3 != null ? mergedList3.toString() : "null")); // Expected: null

        // Test Case 4: Single list
        ListNode l7 = new ListNode(10, new ListNode(20));
        ListNode[] lists4 = {l7};
        ListNode mergedList4 = solver.mergeKLists(lists4);
        System.out.println("Test Case 4: " + (mergedList4 != null ? mergedList4.toString() : "null")); // Expected: 10 -> 20

        // Test Case 5: Empty array of lists
        ListNode[] lists5 = {};
        ListNode mergedList5 = solver.mergeKLists(lists5);
        System.out.println("Test Case 5: " + (mergedList5 != null ? mergedList5.toString() : "null")); // Expected: null
    }
}