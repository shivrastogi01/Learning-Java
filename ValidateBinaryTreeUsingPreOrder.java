class ValidateBinaryTreeUsingPreOrder {
    private TreeNode prev = null;
    public boolean isValidBST(TreeNode root) {
        return isValidBSTUtil(root);
    }
    
    private boolean isValidBSTUtil(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean left = isValidBSTUtil(root.left);
        if (prev != null && prev.val >= root.val) {
            return false;
        }
        prev = root;
        return left && isValidBSTUtil(root.right);
    }
}