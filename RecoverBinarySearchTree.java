class RecoverBinarySearchTree {
    TreeNode firstNode = null;
    TreeNode secondNode = null;
    TreeNode prevNode = new TreeNode(Integer.MIN_VALUE);
    
    public void recoverTree(TreeNode root) {        
        helper(root); // in-order tree traversal -> an in-order tree traversal of a BST returns the values in INCREASING order
        
        int temp = firstNode.val;
        firstNode.val = secondNode.val;
        secondNode.val = temp;
    }
    
    private void helper(TreeNode node) {
        if(node == null) return;
        
        helper(node.left);
        
        if(firstNode == null && prevNode.val > node.val) { // as soo as the value of prev node is larger than curr node, it means the the natural order of in-order is breached, meaning we got our first wrong node
            firstNode = prevNode;
        }
        
        if(firstNode != null && prevNode.val > node.val) { // since we already got first wrong node, this means if ay any time, the curr node value is smaller than prev node (not following ordering from in-order) we got the second wrong node
            secondNode = node;
        }
        
        prevNode = node;
        
        helper(node.right);
    }
}