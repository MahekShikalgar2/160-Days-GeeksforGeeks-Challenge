class TrieNode{
    TrieNode[] children = new TrieNode[2];
    
    public TrieNode() {}
}

class Solution {
    public int maxXor(int[] arr) {
        int max = arr[0];
        for(int num : arr){
            max = Math.max(max, num);
        }
        int maxBits = (int) (Math.log(max) / Math.log(2)) + 1;
        
        TrieNode root = new TrieNode();
        int maxXOR = 0;
        
        for(int num : arr){
            TrieNode node = root;
            int currXOR = 0;
            for(int i=maxBits - 1; i>=0; i--){
                int bit = (num >> i) & 1;
                int oppositeBit = bit == 0 ? 1 : 0;
                if(node.children[oppositeBit] != null){
                    currXOR |= (1 << i);
                    node = node.children[oppositeBit];
                    
                }else if( node.children[bit] != null){
                    node = node.children[bit];
                }else{
                    break;
                }
            }
                maxXOR = Math.max(maxXOR, currXOR);
                
                node = root;
                for(int i= maxBits - 1; i>=0; i--){
                    int bit = (num >> i) & 1;
                    if(node.children[bit] == null){
                        node.children[bit] = new TrieNode();
                    }
                    node = node.children[bit];
                    
                }
            }
            return maxXOR;
        }
}