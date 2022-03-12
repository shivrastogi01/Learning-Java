class DeepestLeafSum {
    
    private int deepestSum;
    private int deepestLevel;
    
    public int deepestLeavesSum(TreeNode root) { 
        this.deepestSum = 0;
        this.deepestLevel = 0;
        
        traverse(root, 0);
        
        return deepestSum;
    }
    
    private void traverse(TreeNode root, int level) {
        if(root == null) {
            return;
        }
                
        if(root.left == null && root.right == null) {
            
            if(this.deepestLevel == level) {
                this.deepestSum += root.val;
            }
            else if(this.deepestLevel < level){
                this.deepestSum = root.val;
                this.deepestLevel = level;
            } 
        }
        
        traverse(root.left, level + 1);
        traverse(root.right, level + 1);
    }
}