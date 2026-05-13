import java.util.HashMap;

// Node class for the Doubly Linked List
class Node {
    int key;
    int value;
    Node prev;
    Node next;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

class LRUCache {
    HashMap<Integer, Node> cache;
    int capacity;
    Node head; // Dummy head node, points to MRU
    Node tail; // Dummy tail node, points to LRU

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        // Initialize dummy head and tail nodes
        head = new Node(0, 0); // Key and value don't matter for dummy nodes
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    // Helper method to add a node right after the head (MRU position)
    private void addNode(Node node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    // Helper method to remove a node from the linked list
    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    // Helper method to move a node to the head (make it MRU)
    private void moveToHead(Node node) {
        removeNode(node);
        addNode(node);
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1; // Cache miss
        }

        Node node = cache.get(key);
        moveToHead(node); // Move to head as it's now most recently used
        return node.value;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            // Key already exists, update value and move to head
            Node node = cache.get(key);
            node.value = value;
            moveToHead(node);
        } else {
            // New key
            Node newNode = new Node(key, value);
            cache.put(key, newNode);
            addNode(newNode); // Add to head

            // If capacity exceeded, remove LRU item
            if (cache.size() > capacity) {
                Node lruNode = tail.prev; // This is the actual LRU node
                removeNode(lruNode);
                cache.remove(lruNode.key); // Also remove from hash map
                // this edge case tripped me up initially, if you just remove from DLL, map still has it!
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Testing LRU Cache with capacity 2:");
        LRUCache lRUCache = new LRUCache(2);

        lRUCache.put(1, 1); // cache is {1=1}
        System.out.println("put(1, 1) -> Cache keys: " + lRUCache.cache.keySet());

        lRUCache.put(2, 2); // cache is {1=1, 2=2}
        System.out.println("put(2, 2) -> Cache keys: " + lRUCache.cache.keySet());

        System.out.println("get(1) -> " + lRUCache.get(1)); // returns 1 (MRU: 1)
        // cache is {2=2, 1=1}
        System.out.println("After get(1) -> Cache keys: " + lRUCache.cache.keySet() + ", MRU (head.next.key): " + lRUCache.head.next.key + ", LRU (tail.prev.key): " + lRUCache.tail.prev.key);

        lRUCache.put(3, 3); // LRU key 2 is evicted, cache is {1=1, 3=3}
        // now 2 should be gone.
        // honestly bolun toh, eviction logic is crucial here.
        System.out.println("put(3, 3) -> Cache keys: " + lRUCache.cache.keySet() + ", MRU (head.next.key): " + lRUCache.head.next.key + ", LRU (tail.prev.key): " + lRUCache.tail.prev.key);

        System.out.println("get(2) -> " + lRUCache.get(2)); // returns -1 (not found)
        System.out.println("After get(2) -> Cache keys: " + lRUCache.cache.keySet());

        lRUCache.put(4, 4); // LRU key 1 is evicted, cache is {3=3, 4=4}
        System.out.println("put(4, 4) -> Cache keys: " + lRUCache.cache.keySet() + ", MRU (head.next.key): " + lRUCache.head.next.key + ", LRU (tail.prev.key): " + lRUCache.tail.prev.key);

        System.out.println("get(1) -> " + lRUCache.get(1)); // returns -1 (not found)
        System.out.println("get(3) -> " + lRUCache.get(3)); // returns 3 (MRU: 3)
        System.out.println("After get(3) -> Cache keys: " + lRUCache.cache.keySet() + ", MRU (head.next.key): " + lRUCache.head.next.key + ", LRU (tail.prev.key): " + lRUCache.tail.prev.key);

        System.out.println("\nTesting LRU Cache with capacity 1:");
        LRUCache lRUCache2 = new LRUCache(1);
        lRUCache2.put(1, 100);
        System.out.println("put(1, 100) -> Cache keys: " + lRUCache2.cache.keySet());
        System.out.println("get(1) -> " + lRUCache2.get(1)); // returns 100
        lRUCache2.put(2, 200); // Evicts 1
        System.out.println("put(2, 200) -> Cache keys: " + lRUCache2.cache.keySet());
        System.out.println("get(1) -> " + lRUCache2.get(1)); // returns -1
        System.out.println("get(2) -> " + lRUCache2.get(2)); // returns 200

        // My current system ensures O(1) for both get and put operations, mast hai.
    }
}