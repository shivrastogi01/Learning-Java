class BinaryTreePruning{
    public TreeNode pruneTree(TreeNode root) {
        TreeNode ans = postOrder(root);
        return ans;
    }

    private TreeNode postOrder(TreeNode cur) {
        if (cur == null) {
            return null;
        }
        TreeNode left = postOrder(cur.left);
        TreeNode right = postOrder(cur.right);
        if (left == null) {
            cur.left = null;
        }
        if (right == null) {
            cur.right = null;
        }
        if (left == null && right == null && cur.val == 0) {
            cur = null;
            return null;
        }
        return cur;
    }
}