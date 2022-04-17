class ConvertBSTToGreaterTree {
    public TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return root;
        }
        
        innerConvertBST(root, 0);
        
        return root;
    }
    
    public int innerConvertBST(TreeNode root, int leftGreater) {
        if (root == null) {
            return 0;
        }
        
        if (root.right != null) {
            root.val += innerConvertBST(root.right, leftGreater);
        } else {
            root.val += leftGreater;
        }
        
        
        if (root.left != null) {
            return innerConvertBST(root.left, root.val);
            
        }
        
        return root.val;
    }
}