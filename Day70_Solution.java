
class Solution {
    public Node cloneLinkedList(Node head) {
     if(head == null){
         return null;
     }
     Node current = head;
     Map<Node, Node> map = new HashMap<>();
     
     while(current != null){
         map.put(current, new Node(current.data));
         current = current.next;
     }
     current = head;
     while(current != null){
         if(current.next != null){
             map.get(current).next = map.get(current.next);
         }
         if(current.random != null){
             map.get(current).random = map.get(current.random);
         }
         current = current.next;
     }
     return map.get(head);
        
    }
}