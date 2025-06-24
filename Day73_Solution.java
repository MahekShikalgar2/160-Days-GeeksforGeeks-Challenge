
class Solution {
    public static void removeLoop(Node head) {
        if(head == null){
            return;
        }
        Node slow = head;
        Node fast = head;
        
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                break;
            }
        }
        if(fast == null || fast.next == null){
            return;
        }
        slow = head;
        if(slow == fast){
            while(fast.next != slow){
                fast = fast.next;
            }
            fast.next = null;
            return;
        }
        while(slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        Node temp = slow;
        while(temp.next != slow){
            temp = temp.next;
        }
        temp.next = null;
        
    }
}