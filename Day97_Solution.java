class Solution {
    Node mergeKLists(List<Node> arr) {
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.data - b.data);
        for(Node node : arr){
            if(node != null){
                pq.add(node);
            }
        }
        Node dummy = new Node(0);
        Node current = dummy;
        while(!pq.isEmpty()){
            Node node = pq.poll();
            current.next = node;
            current = current.next;
            if(node.next != null){
                pq.add(node.next);
            }
        }
        return dummy.next;
    }
}