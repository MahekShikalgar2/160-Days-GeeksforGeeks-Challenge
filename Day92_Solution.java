class Solution {
    Node first = null, second = null, prev = null;
    void correctBST(Node root) {
        inorder(root);
        int temp = first.data;
        first.data = second.data;
        second.data = temp;
      
    }
    void inorder(Node node){
        if(node == null){
            return;
        }
        inorder(node.left);
        if(prev != null && node.data < prev.data){
            if(first == null){
                first = prev;
            }
            second = node;
        }
        prev = node;
        inorder(node.right);
    }
}