class LinklistRandomNode {
    List<Integer> li;
    int n;
    Random r ;
    public Solution(ListNode head) {
        li = new ArrayList<>();
        ListNode temp = head;
        while(temp != null){
            li.add(temp.val);
            temp = temp.next;
        }// Convert the linked list data to array list --> (1)
        n = li.size(); // Number of nodes in the list --> (2)
        r = new Random(); // Object for random Class --> (3)
    }
    
    /** Returns a random node's value. */
    public int getRandom() {
        int l = r.nextInt(n); // Get the random number from 0 to n-1
        return li.get(l);
    }
}