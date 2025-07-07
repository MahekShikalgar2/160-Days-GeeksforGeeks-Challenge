class Solution {
    ArrayList<Integer> boundaryTraversal(Node node) {
        ArrayList<Integer> result = new ArrayList<>();
        if(node == null){
            return result;
        }
        if(!isLeaf(node)){
            result.add(node.data);
        }
        Node current = node.left;
        while(current != null){
            if(!isLeaf(current)){
                result.add(current.data);
            }
            if(current.left != null){
                current = current.left;
            }else{
                current = current.right;
            }
        }
        addLeafNodes(node, result);
        Stack<Integer> stack = new Stack<>();
        current = node.right;
        while(current != null){
            if(!isLeaf(current)){
                stack.push(current.data);
            }
            if(current.right != null){
                current = current.right;
            }else{
                current = current.left;
            }
        }
        while(!stack.isEmpty()){
            result.add(stack.pop());
        }
        return result;
        
    }
    void addLeafNodes(Node node, ArrayList<Integer> result){
        if(isLeaf(node)){
            result.add(node.data);
        }
        if(node.left != null){
            addLeafNodes(node.left, result);
        }
        if(node.right != null){
            addLeafNodes(node.right, result);
        }
    }
    boolean isLeaf(Node node){
        return node.left == null && node.right == null;
    }
}