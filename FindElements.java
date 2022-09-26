class FindElements {
    
    
    void recover(TreeNode root,int val,HashSet<Integer> hs){
        root.val=val;
        hs.add(val);
        if(root.left!=null) recover(root.left,2*val+1,hs);
        if(root.right!=null) recover(root.right,2*val+2,hs);
    }  
    
   
    TreeNode node;
    HashSet<Integer> hs;
    public FindElements(TreeNode root) {        
        node = root;
        hs = new HashSet<>();
        recover(node,0,hs);
    }
    
    public boolean find(int target) {
        return hs.contains(target);
    }
}