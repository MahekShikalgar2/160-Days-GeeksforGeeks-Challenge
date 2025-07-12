class Solution {
    HashSet<Integer> set = new HashSet<>();
    boolean findTarget(Node root, int target) {
       return findPair(root, target);
        
    }
    boolean findPair(Node node, int target){
        if(node == null){
            return false;
        }
        if(findPair(node.left, target)){
            return true;
        }
        if(set.contains(target - node.data)){
            return true;
        }
        set.add(node.data);
        return findPair(node.right, target);
    }
}