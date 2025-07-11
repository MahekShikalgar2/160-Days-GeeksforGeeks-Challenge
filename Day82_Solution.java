class Solution {
    int diameter(Node root) {
        int[] diameter = new int[1];
        height(root, diameter);
        return diameter[0];
        
    }
    int height(Node node, int[] diameter){
        if(node == null){
            return 0;
        }
        int leftHeight = height(node.left, diameter);
        int rightHeight = height(node.right, diameter);
        
        diameter[0] = Math.max(diameter[0], leftHeight + rightHeight);
        return Math.max(leftHeight, rightHeight) + 1;
    }
}