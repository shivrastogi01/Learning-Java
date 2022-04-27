class BottomLeftTreeValue {
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        while(!que.isEmpty()){
            root = que.poll();
            if(root.right != null){
                que.add(root.right);
            }
            if(root.left != null){
                que.add(root.left);
            } 
        }
        return root.val;
    }
}