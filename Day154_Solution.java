class TrieNode{
    TrieNode[] children = new TrieNode[26];
    boolean isEndOfWord;
    
    public TrieNode() {}
}
class Trie{
    private TrieNode root;
    
    public Trie(){
        root = new TrieNode();
    }
    public void insert(String word){
        TrieNode node = root;
        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);
            if(node.children[ch -'a'] == null){
                node.children[ch - 'a'] = new TrieNode();
            }
            node = node.children[ch - 'a'];
        }
        node.isEndOfWord = true;
    }

    public boolean search(String word) {
        TrieNode node = root;
        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);
            if(node.children[ch - 'a'] == null){
                return false;
            }
            node = node.children[ch - 'a'];
        }
        return node.isEndOfWord;
    }

    public boolean isPrefix(String word) {
        TrieNode node = root;
        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);
            if(node.children[ch - 'a'] == null){
                return false;
            }
            node = node.children[ch - 'a'];
        }
        return true;
    }
}