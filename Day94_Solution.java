class Tree {
    int index = -1;
    public ArrayList<Integer> serialize(Node root) {
        ArrayList<Integer> list = new ArrayList<>();
        serializeUtil(root, list);
        return list;
    }
    void serializeUtil(Node node, ArrayList<Integer> list){
        if(node == null){
            list.add(-1);
            return;
        }
        list.add(node.data);
        serializeUtil(node.left, list);
        serializeUtil(node.right, list);
    }
    public Node deSerialize(ArrayList<Integer> arr) {
        index++;
        if(index >= arr.size() || arr.get(index) == -1){
            return null;
        }
        Node node = new Node(arr.get(index));
        node.left = deSerialize(arr);
        node.right = deSerialize(arr);
        return node;
        
       
    }
}