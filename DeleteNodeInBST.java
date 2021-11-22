class DeleteNodeInBST {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return null;
        if(key == root.val){
            if(root.left == root.right) return null;
            if(root.left == null) return root.right;
            if(root.right == null) return root.left;
            TreeNode curr = root.right;
            while(curr.left != null)
                curr = curr.left;
            deleteNode(root, curr.val);
            curr.right = root.right;
            curr.left = root.left;
            return curr;
        }
        if(key < root.val) {
            root.left = deleteNode(root.left, key);
        } else {
            root.right = deleteNode(root.right, key);
        }
        return root;
    }
}