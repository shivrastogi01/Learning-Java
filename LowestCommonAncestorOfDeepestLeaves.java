class LowestCommonAncestorOfDeepestLeaves {

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        if(root==null || height(root.right)==height(root.left))return root;
        return lcaDeepestLeaves(height(root.left)>height(root.right)?root.left:root.right);
    }
    
    public int height(TreeNode root){
        if(root==null)return 0;
        return 1 + Math.max(height(root.left),height(root.right));
    }
    
}