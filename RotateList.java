class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null) return null;
        if(k == 0) return head;
        
        int nodeSize = 1;
        ListNode curr = head;
        ListNode kPrevNode = head;
        boolean foundKPrevNode = false;
        ListNode tailPrevNode = null;
        ListNode tailNode = null;
        while(true){
            if(curr.next == null) break;
            nodeSize++;
            if(nodeSize > k+1){
                kPrevNode = kPrevNode.next;
                foundKPrevNode = true;
            }
            tailPrevNode = curr;
            curr = curr.next;
            tailNode = curr;
        }
        if(!foundKPrevNode) kPrevNode = null;
        if(k >= nodeSize && k % nodeSize == 0) return head;
        
        
        if(kPrevNode == null){
            int kPrevNodeIdx = nodeSize - (k % nodeSize) - 1;
            for(int i=0; i <= kPrevNodeIdx; i++){
                if(kPrevNode == null) kPrevNode = head;
                else kPrevNode = kPrevNode.next;
            }
        }
        
        if (kPrevNode.next == null){
            return head;
        }
        
        tailNode.next = head;
        head = kPrevNode.next;
        kPrevNode.next = null;
        
        return head;
        
        
        
    }
    
}