class SortList {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        int size = getSize(head);
        return sort(head, size);
    }
    
    private ListNode sort(ListNode node, int size) {
        if (size == 1) {
            return node;
        }
        
        int mid = size / 2;
        
        ListNode left = node;
        ListNode right = node;
        for (int i = 0; i < mid; ++i) {
            right = right.next;
        }
        
        left = sort(left, mid);
        right = sort(right, size - mid);
        
        return merge(left, mid, right, size - mid);
    }
    
    private ListNode merge(ListNode left, int leftSize, ListNode right, int rightSize) {
        ListNode result = new ListNode();
        ListNode node = result;
        
        while (leftSize > 0 && rightSize > 0) {
            if (left.val < right.val) {
                node.next = left;
                --leftSize;
                left = left.next;
            } else {
                node.next = right;
                --rightSize;
                right = right.next;
            }
            node = node.next;
        }
        
        while (leftSize-- > 0) {
            node.next = left;
            left = left.next;
            node = node.next;
        }
        
        node.next = right;
        return result.next;
    }
    
    private int getSize(ListNode node) {
        int size = 0;
        while (node != null) {
            node = node.next;
            ++size;
        }
        return size;
    }
}