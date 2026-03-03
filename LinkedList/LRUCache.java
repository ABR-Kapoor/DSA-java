class LRUCache {

    // Inner Node class for the Doubly Linked List
    class Node {
        int key;
        int value;
        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.prev = null;
            this.next = null;
        }
    }

    private int capacity;
    private int currentSize;
    private java.util.HashMap<Integer, Node> nodeMap;
    private Node head; // Dummy head node, points to MRU
    private Node tail; // Dummy tail node, points to LRU

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.currentSize = 0;
        this.nodeMap = new java.util.HashMap<>();

        // Initialize dummy head and tail nodes
        this.head = new Node(0, 0); // Dummy key, value
        this.tail = new Node(0, 0); // Dummy key, value

        // Link head and tail initially
        head.next = tail;
        tail.prev = head;
        // This Node class is the backbone; gotta store key and value both so we can easily remove from map later.
    }

    // Adds a node right after the head (making it MRU)
    private void addNode(Node node) {
        node.next = head.next;
        node.prev = head;

        head.next.prev = node;
        head.next = node;
    }

    // Removes a given node from the list
    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        // Moving a node to front means removing it from its current spot and re-inserting right after 'head'.
    }

    public int get(int key) {
        if (!nodeMap.containsKey(key)) {
            return -1;
        }

        Node node = nodeMap.get(key);
        removeNode(node); // Remove from current position
        addNode(node);    // Add to front (MRU)
        return node.value;
    }

    public void put(int key, int value) {
        if (nodeMap.containsKey(key)) {
            Node node = nodeMap.get(key);
            node.value = value; // Update value
            removeNode(node);   // Remove from current position
            addNode(node);      // Add to front (MRU)
        } else {
            Node newNode = new Node(key, value);
            nodeMap.put(key, newNode);
            addNode(newNode);
            currentSize++;

            if (currentSize > capacity) {
                // The LRU node is always right before the dummy tail
                Node lruNode = tail.prev;
                removeNode(lruNode);
                nodeMap.remove(lruNode.key);
                currentSize--;
                // Edge case: when capacity is hit, the 'tail.prev' is *always* the LRU. This dummy node approach makes it clean.
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Test Case 1: Basic operations");
        LRUCache lruCache1 = new LRUCache(2);
        lruCache1.put(1, 10);
        lruCache1.put(2, 20);
        System.out.println("Get 1: " + lruCache1.get(1)); // returns 10 (1 becomes MRU)
        lruCache1.put(3, 30); // evicts key 2
        System.out.println("Get 2: " + lruCache1.get(2)); // returns -1 (not found)
        lruCache1.put(4, 40); // evicts key 3
        System.out.println("Get 1: " + lruCache1.get(1)); // returns 10 (1 becomes MRU)
        System.out.println("Get 3: " + lruCache1.get(3)); // returns -1 (not found)
        System.out.println("Get 4: " + lruCache1.get(4)); // returns 40 (4 becomes MRU)

        System.out.println("\nTest Case 2: Capacity 1");
        LRUCache lruCache2 = new LRUCache(1);
        lruCache2.put(1, 100);
        System.out.println("Get 1: " + lruCache2.get(1)); // returns 100
        lruCache2.put(2, 200); // evicts key 1
        System.out.println("Get 1: " + lruCache2.get(1)); // returns -1
        System.out.println("Get 2: " + lruCache2.get(2)); // returns 200

        System.out.println("\nTest Case 3: Update and then evict");
        LRUCache lruCache3 = new LRUCache(3);
        lruCache3.put(1, 11);
        lruCache3.put(2, 22);
        lruCache3.put(3, 33); // Current order: 3(MRU) - 2 - 1(LRU)
        System.out.println("Get 1: " + lruCache3.get(1)); // returns 11. Order: 1(MRU) - 3 - 2(LRU)
        lruCache3.put(4, 44); // evicts key 2
        System.out.println("Get 2: " + lruCache3.get(2)); // returns -1
        System.out.println("Get 3: " + lruCache3.get(3)); // returns 33. Order: 3(MRU) - 4 - 1(LRU)
    }
}