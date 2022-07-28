class DiameterOfBinaryTree1 {
    public int diameterOfBinaryTree(TreeNode root) {
        return dfs(root)[1];
    }

    public int[] dfs(TreeNode root) {

        if (root == null) return new int[]{0, 0}; // [height, diameter]

        int[] left = dfs(root.left);
        int[] right = dfs(root.right);

        int height = 1 + Math.max(left[0], right[0]);
        int diameter = Math.max(left[0] + right[0], Math.max(left[1], right[1]));
        return new int[]{height, diameter};
    }
}