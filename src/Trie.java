//search function to highlight all roads
//whose name is prefixed by the search input
//store all road objects indexed by their names
//methods to add a new road
//retrieve all roads matching a given prefix

public class Trie {
	
	public static final int ALPHABET_SIZE = 26;
    
    // trie node
   public  static class TrieNode {
        TrieNode[ ] children = new TrieNode[ALPHABET_SIZE];
        boolean isEndOfWord;
         
        TrieNode() {
            isEndOfWord = false;
            for (int i = 0; i < ALPHABET_SIZE; i++)
                children[i] = null; }
    };
      
    static TrieNode root; 
     
    // inserts key into trie, if its not present
    // If key is prefix of trie's node, mark leaf
    
    static void insert(String key)
    {
        int l;
        int keylength = key.length();
        int index;
      
        TrieNode trienode = root;
      
        for (l = 0; l < keylength; l++)
        {
            index = key.charAt(l) - 'a';
            if (trienode.children[index] == null)
                trienode.children[index] = new TrieNode();
      
            trienode = trienode.children[index];
        }
      
       
        trienode.isEndOfWord = true;
    }
      
}
