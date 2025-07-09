class Solution {
    public int sumK(Node root, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        return sumKUtil(root, 0, k, map);
    }
    int sumKUtil(Node node, int sum, int k, HashMap<Integer, Integer> map){
        if(node == null){
            return 0;
        }
        sum += node.data;
       int count = map.getOrDefault(sum - k, 0);
        map.put(sum, map.getOrDefault(sum, 0) + 1);
        count += sumKUtil(node.left, sum, k, map);
        count += sumKUtil(node.right, sum, k, map);
        map.put(sum, map.get(sum) - 1);
        if(map.get(sum) == 0){
            map.remove(sum);
        }
        return count;
    }
}