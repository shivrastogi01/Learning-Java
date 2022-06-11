class BinarySearchTreeWithGreaterSum {
    public TreeNode bstToGst(TreeNode root) {
        if(root == null) return null;
        int[] res = new int[]{0};
        bstToGstHelper(root, res);
        return root;
    }
    
    public void bstToGstHelper(TreeNode root, int[] res){
        if(root == null) return;
        bstToGstHelper(root.right, res);
        res[0] += root.val;
        root.val = res[0];
        bstToGstHelper(root.left, res);
    }
    
}