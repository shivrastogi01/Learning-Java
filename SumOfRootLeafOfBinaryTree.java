class SumOfRootLeafOfBinaryTree {
    
     private int sm =0;
     int sum_leaf(TreeNode t,String k){
        if (t==null) 
            return 0;
        sum_leaf(t.left,k+t.val);   
        if (t.left==null && t.right==null) {
            sm+= Integer.parseInt((k+t.val), 2);
        }
        return sum_leaf(t.right,k+t.val);
    }
    public int sumRootToLeaf(TreeNode root) {
        if(root==null)
            return 0;
        if (root.left==null && root.right==null) {
            return root.val ;
        }
        sum_leaf(root,"") ;
        return sm ;
    }
}