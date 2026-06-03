import java.util.HashMap;
import java.util.Map;

// This feels like something I'd write quickly after understanding the concept.
class TrieImplementation {

    // Inner static class for TrieNode. 
    // static because it doesn't need an instance of TrieImplementation to exist.
    private static class TrieNode {
        Map<Character, TrieNode> children;
        boolean isEndOfWord; // true if this node marks the end of a complete word

        public TrieNode() {
            children = new HashMap<>();
            isEndOfWord = false;
        }
    }

    private TrieNode root; // The starting point of our Trie

    public TrieImplementation() {
        root = new TrieNode(); // Initialize the Trie with an empty root node
    }

    /**
     * Inserts a word into the Trie.
     * Iterates through each character, creating nodes if they don't exist.
     */
    public void insert(String word) {
        TrieNode current = root; // Start from the root
        for (char ch : word.toCharArray()) {
            // Add the character as a child if it's not already there
            current.children.putIfAbsent(ch, new TrieNode());
            current = current.children.get(ch); // Move to the next node
        }
        current.isEndOfWord = true; // Mark the end of the word
        // yaar, this `isEndOfWord` flag is super important, missed it first time.
    }

    /**
     * Searches for a word in the Trie.
     * Returns true if the word exists as a complete word.
     */
    public boolean search(String word) {
        TrieNode current = root;
        for (char ch : word.toCharArray()) {
            if (!current.children.containsKey(ch)) {
                return false; // Character not found, so word doesn't exist
            }
            current = current.children.get(ch);
        }
        // The path for the word exists, but is it a complete word?
        return current.isEndOfWord; 
    }

    /**
     * Checks if there is any word in the Trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        TrieNode current = root;
        for (char ch : prefix.toCharArray()) {
            if (!current.children.containsKey(ch)) {
                return false; // Prefix character not found
            }
            current = current.children.get(ch);
        }
        // If we reached here, it means the entire prefix path exists.
        return true; 
        // took me a while to realize `startsWith` doesn't care about `isEndOfWord`, only if the path exists.
    }

    // Main method for testing our Trie implementation
    public static void main(String[] args) {
        TrieImplementation trie = new TrieImplementation();

        System.out.println("Inserting words: apple, app, apricot, apply");
        trie.insert("apple");
        trie.insert("app");
        trie.insert("apricot");
        trie.insert("apply");
        // Used HashMap for children, easier than fixed array for all chars. Maybe array for competitive coding for speed, but this is fine for now.

        System.out.println("\n--- Search Tests ---");
        System.out.println("Search 'apple': " + trie.search("apple"));    // Expected: true
        System.out.println("Search 'app': " + trie.search("app"));        // Expected: true
        System.out.println("Search 'apricot': " + trie.search("apricot")); // Expected: true
        System.out.println("Search 'appl': " + trie.search("appl"));      // Expected: false (Path exists, but not a full word)
        System.out.println("Search 'banana': " + trie.search("banana"));  // Expected: false
        System.out.println("Search 'apply': " + trie.search("apply"));    // Expected: true

        System.out.println("\n--- StartsWith Tests ---");
        System.out.println("Starts with 'app': " + trie.startsWith("app"));      // Expected: true
        System.out.println("Starts with 'appl': " + trie.startsWith("appl"));    // Expected: true (because 'apple' and 'apply' exist)
        System.out.println("Starts with 'apric': " + trie.startsWith("apric"));  // Expected: true
        System.out.println("Starts with 'banana': " + trie.startsWith("banana"));// Expected: false
        System.out.println("Starts with 'apple': " + trie.startsWith("apple"));  // Expected: true
        System.out.println("Starts with 'a': " + trie.startsWith("a"));          // Expected: true
        System.out.println("Starts with '': " + trie.startsWith(""));            // Expected: true (empty prefix matches everything)
    }
}