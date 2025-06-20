
class Solution {
    
    static Node reverse (Node head){
        Node prev = null;
        Node curr = head;
        Node next = null;
        while(curr != null){
            next = curr.next;
            curr.next =prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    static Node trimLeadingZeros(Node head){ 
        while(head != null && head.data == 0 && head.next != null){
            head = head.next;
        }
        return head;
        
    }
    static Node addTwoLists(Node num1, Node num2) {
        Node res = null;
        Node curr = null;
        num1 = trimLeadingZeros(num1);
        num2 = trimLeadingZeros(num2);
        num1 = reverse(num1);
        num2 = reverse(num2);
        
        Node dummy = new Node(0);
        Node current = dummy;
        int carry = 0;
        
        while(num1 != null || num2 != null || carry != 0){
            int sum = carry;
            if(num1 != null){
                sum += num1.data;
                num1 = num1.next;
            }
            if(num2 != null){
                sum += num2.data;
                num2 = num2.next;
            }
            Node newNode = new Node(sum % 10);
        
            carry = sum / 10;
            if(res == null){
                res = newNode;
                curr = newNode;
            } else{
                curr.next = newNode;
                curr = curr.next;
            }
            
        }
        return trimLeadingZeros(reverse(res));
    }
}