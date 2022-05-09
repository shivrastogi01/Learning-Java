class LinkedListComponent{
    public int numComponents(ListNode head, int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i:nums){
            map.put(i,0);//using map to store the nums array element
        }
        boolean bol = false;
        int count=0;
       if(map.containsKey(head.val)){ bol=true;}
        while(head!=null){
            if(map.containsKey(head.val)){
                if(bol) count++;// counting connected components
                bol=false;
            }
            else{
                bol=true;
            }
            head=head.next;
        }
        return count;
    }
}