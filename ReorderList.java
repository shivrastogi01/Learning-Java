class ReorderList{
   public void reorderList(ListNode head) {
      if(head == null || head.next == null || head.next.next == null) {
          return;
      }
        ListNode start = head;
        int length = 2;
        ListNode end = head.next;
        Deque<ListNode> queue = new ArrayDeque<>();
        while(end != null && end.next != null) {
                queue.push(start);
                end = end.next;
                if(end.next == null) {
                    length ++;
                }else {
                    length += 2;
                }
                end = end.next;
                start = start.next;
        }
        ListNode secondPoi = start.next;
        
        if(length % 2 == 0) {
           secondPoi  = start.next.next;
            start.next.next = null;
        } else {
            start.next = null;
        }
        
        while(!queue.isEmpty() && secondPoi != null) {
            ListNode tempSecond = secondPoi.next;
            ListNode tempStart = queue.poll();
            secondPoi.next = tempStart.next;
            tempStart.next = secondPoi;
            secondPoi = tempSecond;
        }
    }
}