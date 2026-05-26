class TrieNode {
    TrieNode[] children;
    boolean isEndOfWord;

    public TrieNode() {
        children = new TrieNode[26]; // For 'a' through 'z'
        isEndOfWord = false;
    }
}

class TrieImplementation {
    private TrieNode root;

    public TrieImplementation() {
        root = new TrieNode();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        TrieNode currentNode = root; // Start from the root
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            if (currentNode.children[index] == null) {
                currentNode.children[index] = new TrieNode();
            }
            currentNode = currentNode.children[index];
        }
        currentNode.isEndOfWord = true;
    }

    /**
     * Returns true if the word is in the trie.
     */
    public boolean search(String word) {
        TrieNode currentNode = root;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            if (currentNode.children[index] == null) {
                return false; // Character not found in path
            }
            currentNode = currentNode.children[index];
        }
        // After traversing the word, check if it actually marks the end of a word.
        // This is crucial, e.g., "apple" is in trie, but "app" is not a full word unless marked.
        return currentNode.isEndOfWord; // this edge case tripped me up initially, if "apple" is there, "app" won't return true unless explicitly inserted
    }

    /**
     * Returns true if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        TrieNode currentNode = root;
        for (char ch : prefix.toCharArray()) {
            int index = ch - 'a';
            if (currentNode.children[index] == null) {
                return false; // Prefix path doesn't exist
            }
            currentNode = currentNode.children[index];
        }
        return true; // If we reached here, the prefix path exists
    }

    public static void main(String[] args) {
        TrieImplementation trie = new TrieImplementation();

        // Test Case 1: Basic insertions and searches
        trie.insert("apple");
        trie.insert("app"); // Tried recursive first but iterative is cleaner here for trie operations.
        System.out.println("Search 'apple': " + trie.search("apple"));   // Expected: true
        System.out.println("Search 'app': " + trie.search("app"));     // Expected: true
        System.out.println("Search 'ap': " + trie.search("ap"));       // Expected: false (since "ap" wasn't inserted as a full word)
        System.out.println("Starts with 'ap': " + trie.startsWith("ap")); // Expected: true
        System.out.println("Starts with 'appl': " + trie.startsWith("appl")); // Expected: true
        System.out.println("Starts with 'bat': " + trie.startsWith("bat")); // Expected: false

        System.out.println("---");

        // Test Case 2: More words and different scenarios
        trie.insert("banana");
        trie.insert("band");
        trie.insert("badge");
        System.out.println("Search 'banana': " + trie.search("banana")); // Expected: true
        System.out.println("Search 'band': " + trie.search("band"));   // Expected: true
        System.out.println("Search 'ban': " + trie.search("ban"));    // Expected: false
        System.out.println("Starts with 'ban': " + trie.startsWith("ban")); // Expected: true
        System.out.println("Starts with 'bandana': " + trie.startsWith("bandana")); // Expected: false

        System.out.println("---");

        // Test Case 3: Edge cases / non-existent words
        System.out.println("Search 'bannn': " + trie.search("bannn"));   // Expected: false
        System.out.println("Starts with 'xyz': " + trie.startsWith("xyz")); // Expected: false
        System.out.println("Search empty string '': " + trie.search("")); // Expected: false (if an empty string can't be a word)
        // O(N) space for TrieNodes, where N is total characters across all unique words. Acceptable for now.
    }
}