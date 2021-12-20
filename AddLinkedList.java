class AddLinkedList {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int dec = 0;
        ListNode curr1 = l1, curr2 = l2, res = new ListNode(0), curr = res;
        boolean l1Null = false, l2Null = false;

        while (!l1Null || !l2Null) {
            curr.next= new ListNode((curr1.val+curr2.val+dec)%10);
            dec = (curr1.val+curr2.val+dec)/10;

            curr = curr.next;

            if (curr1.next == null) {
                curr1.val = 0;
                l1Null = true;
            } else {
                curr1 = curr1.next;
            }

            if (curr2.next == null) {
                curr2.val = 0;
                l2Null = true;
            } else {
                curr2 = curr2.next;
            }
        }
                if (dec>0) curr.next = new ListNode(dec);
        return res.next;
    }
}