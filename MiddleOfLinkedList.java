class MiddleOfLinkedList {
    public ListNode middleNode(ListNode head) {
     
        ListNode first = head;
        ListNode second = head;
        
        while(second.next != null && second.next.next != null){
            
            first = first.next;
            second = second.next.next;
            
        }
        if(second.next == null){
             return first;
        }else{
            return first.next;
    }
        }
       
    }
