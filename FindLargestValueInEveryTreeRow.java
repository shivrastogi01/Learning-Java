class FindLargestValueInEveryTreeRow{
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> lst = new ArrayList<>();    
        int t = height(root); 
        for(int i = 0; i < t; ++i) {
            lst.add(getMaxByLevel(root, 0, i)); 
        }
        return lst; 
        
    }
    public int height(TreeNode root) {
        if(root == null) { 
            return 0; 
        }
            return 1 + Math.max(height(root.left), height(root.right)); 
    }
    public int getMaxByLevel(TreeNode root, int i, int k) {
        if(root == null) {
            return Integer.MIN_VALUE; 
        }
        if(i == k) {
            return root.val; 
        }
        return Math.max(getMaxByLevel(root.left, i + 1, k), getMaxByLevel(root.right, i + 1, k)); 
    }
    
}