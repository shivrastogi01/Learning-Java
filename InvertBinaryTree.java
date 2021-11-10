class InvertBinaryTree {
    
    // Flip left and right recursive
    public TreeNode invertTree(TreeNode root) {
        
        if(root == null)
            return null;
        
        TreeNode newLeft = null;
        TreeNode newRight = null;
            
        // invert left
        if(root.left != null)
            newRight = invertTree(root.left);
        
        // invert right
        if(root.right != null)
            newLeft = invertTree(root.right);
        
        // swap left and right
        root.left = newLeft;
        root.right = newRight;
        
        return root;
    }
}