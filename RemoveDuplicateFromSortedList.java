/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

   class RemoveDuplicateFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null || head.next==null) return head;
        HashMap<Integer,Integer> hm= new HashMap<>();
        ListNode curr = new ListNode(9999);
        curr.next=head;
        head=curr;

          while(curr!=null){
            hm.put(curr.val,hm.getOrDefault(curr.val,0)+1);
              curr=curr.next;
          }
        curr=head;
        ListNode ans=new ListNode(0),uttar=ans;
        while(curr!=null){
            if(hm.get(curr.val)<2) {
                ans.next=new ListNode(curr.val);
                ans=ans.next;
            }
            curr=curr.next;
          }
        
        return uttar.next.next;
    }
}