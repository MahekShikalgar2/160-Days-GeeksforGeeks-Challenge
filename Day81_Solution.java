class Solution {
    int height(Node node) {
        if(node == null){
            return 0;
        }
        if(node.left == null && node.right == null){
            return 0;
        }
        int leftHeight = height(node.left);
        int rightHeight = height(node.right);
        
        return Math.max(leftHeight, rightHeight) + 1;
        
    }
}