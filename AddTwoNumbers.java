import java.io.*;

class ListNode {
   int val;
   ListNode next;
   ListNode() {}
   ListNode(int val) { this.val = val; }
  ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
class AddTwoNumbers {
		public static void main(String [] args){
		ListNode addTwoNumbers(ListNode l1, ListNode l2);
			System.out.println(cur);
			
			
		}
    int carry = 0 ;
   public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int sum = 0  ;
		// if list is empty then create new lists , because we cannot add the values of list if they are null
        if (l1==null){
            l1 = new ListNode() ;
        }
        if (l2==null){
            l2 =new ListNode() ;
        }
        ListNode cur = new ListNode() ; // this will contain our answer
        sum = l1.val + l2.val + carry  ; // add the values of both lists , add carry too 
        if (sum>9) {
            carry = 1 ;
            sum = sum%10 ;
        } else {
            carry = 0 ;
        }
        cur.val = sum ; 
        l1 = l1.next ; // moving the node of list to the next node
        l2 = l2.next ; // same as above
        if (l1==null){
            l1 = new ListNode() ;  // creating a new list because we can't pass a null list through the func
        }
        if (l2==null){
            l2 =new ListNode() ; // same
        }
		// if both values of lists are zero that means the list ended 
		// if both values of lists are actually zero then do recursion ( carry != 0 )
		// if both values of lists are zero and carry is also zero then don't do recursion if the next node          
		// of both the lists are null ( means last nodes ) , do a recursion if either of them is not null  
        if ((l1.val != 0) || (l2.val != 0) || (carry != 0) || (l1.next != null) || (l2.next != null)){
            cur.next = addTwoNumbers(l1,l2) ;
        }
        return cur ; // since no next node left we return the solution list 
    }
	
}