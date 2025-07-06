class Solution {
    ArrayList<Integer> inOrder(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        inOrderUtil(root, result);
        return result;
        
    }
    void inOrderUtil(Node node, ArrayList<Integer> result){
        if(node == null){
            return;
        }
        inOrderUtil(node.left, result);
        result.add(node.data);
        inOrderUtil(node.right, result);
    }
}