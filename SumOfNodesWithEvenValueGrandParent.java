class SumOfNodesWithEvenValueGrandParent{
    private int result = 0;
    public int sumEvenGrandparent(TreeNode root) {
        
        dfs(root,-1,-1);
        return result;
    }
    
    public void dfs(TreeNode root, int p, int gp){
        
        if(root == null) return;
        
        if(gp % 2 == 0){
            result += root.val;
        }
        
        gp = p;
        p = root.val;
        
        if(root.left != null) dfs(root.left, p, gp);
        if(root.right != null) dfs(root.right, p, gp);
    }
}