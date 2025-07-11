class Solution {
    int count = 0;
    int result = -1;
    public int kthSmallest(Node root, int k) {
        inorder(root, k);
        return result;
    }
    void inorder(Node node, int k){
        if(node == null || count >= k){
            return;
        }
        inorder(node.left, k);
        count++;
        if(count == k){
            result = node.data;
            return;
        }
        inorder(node.right, k);
    }
}