class ConstructBinaryTreeFromPreOrder {
    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root = null;
        for(int i=0;i<preorder.length;i++){
            root = addNode(root, preorder[i]);
        }
        return root;
    }
    public TreeNode addNode(TreeNode root, int val){
        if(root == null)
            root = new TreeNode(val);
        else if(root.val > val)
            root.left = addNode(root.left,val);
        else if(root.val < val)
            root.right = addNode(root.right, val);
        return root;
    }
}