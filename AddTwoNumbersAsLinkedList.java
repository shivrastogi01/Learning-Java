class AddTwoNumbersAsLinkedList {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<>();
        while(l1 != null){
            s1.push(l1.val);
            l1 = l1.next;
        }
        Stack<Integer> s2 = new Stack<>();
        while(l2 != null){
            s2.push(l2.val);
            l2 = l2.next;
        }
        int carry = 0;
        List<Integer> list = new ArrayList();
        while(!s1.isEmpty() && !s2.isEmpty()){
            int sum = s1.pop()+s2.pop()+carry;
            carry = sum/10;
            sum = sum % 10;
            list.add(sum);
        }
        while(!s1.isEmpty()){
            int sum = s1.pop()+carry;
            carry = sum/10;
            sum = sum % 10;
            list.add(sum);
        }
        while(!s2.isEmpty()){
            int sum = s2.pop()+carry;
            carry = sum/10;
            sum = sum % 10;
            list.add(sum);
        }
        if(carry > 0)
            list.add(carry);
        Collections.reverse(list);
        ListNode ans = new ListNode(list.get(0));
        ListNode temp = ans;
        for(int i=1; i<list.size(); i++){
            temp.next = new ListNode(list.get(i));
            temp = temp.next;
        }
        return ans;
    }
}