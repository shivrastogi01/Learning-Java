class CountTreeNodes {
    public int countNodes(TreeNode root) {
        
        if(root==null)
            return 0;
        int lef=0,rig=0;
        TreeNode tmp=root;
        while(tmp.left!=null) {
		
            tmp=tmp.left;
            lef++;
        }
        tmp=root;
        while(tmp.right!=null){
		
            tmp=tmp.right;
            rig++;
        }
        if(lef==rig)
            return 2*((int)Math.pow(2,lef)-1)+1;
        return countNodes(root.left)+countNodes(root.right)+1;
    }
}