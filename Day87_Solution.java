class Solution {
    int maxSum = Integer.MIN_VALUE;
    int findMaxSum(Node node) {
        maxPathSum(node);
        return maxSum;
       
    }
    int maxPathSum(Node node){
        if(node == null){
            return 0;
        }
        int leftSum = Math.max(maxPathSum(node.left), 0);
        int rightSum = Math.max(maxPathSum(node.right), 0);
        
        maxSum = Math.max(maxSum, node.data + leftSum + rightSum);
        return node.data + Math.max(leftSum, rightSum);
    }
}