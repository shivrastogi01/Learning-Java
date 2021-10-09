class CheckSymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        
       return call(root.left,root.right);
    }

    boolean call(TreeNode root1,TreeNode root2){
        if(root1 == null && root2 ==null)
            return true;
        if(root1 == null && root2 != null )
            return false;
        if(root1 != null && root2 == null)
            return false;
        if(root1.val!=root2.val)
            return false;
        return call(root1.left,root2.right)&&call(root1.right,root2.left);
    }
}