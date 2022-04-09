class CopyListWithRandom {
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        Node temp = head;
		
		// Step 1
        while(temp != null) {
            Node node = new Node(temp.val);
            node.next = temp.next;
            temp.next = node;

            temp = temp.next.next;
        }

		// Step 2
        temp = head;
        Node newHead = head.next;
        
        while(temp.next.next != null) {
            Node node = temp.next;
            node.random = temp.random == null ? null : temp.random.next;
            temp = temp.next.next;
        }
        temp.next.random =  temp.random == null ? null : temp.random.next;
		
		// Step 3
        temp = head;
        while(temp.next.next != null) {
            Node node = temp.next;
            Node next = node.next;
            
            node.next  = next.next;
            temp.next = next;
            temp = next;
        }
        
        temp.next = null;
        return newHead;
    }
}