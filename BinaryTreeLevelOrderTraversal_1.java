class BinaryTreeLevelOrderTraversal_1 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> loB=new LinkedList();
        if(root==null) return loB;
        
        Queue<TreeNode> queue=new LinkedList();
        queue.add(root);
        while(queue.size()>0 ){
            int n=queue.size();
            List<Integer> list=new LinkedList();
            for(int i=0 ; i< n ; i++ ){
                TreeNode node =queue.poll();
                list.add(node.val);
                if(node.left!=null) queue.add(node.left);
                if(node.right!=null) queue.add(node.right);
            }
            loB.addFirst(list);
        }
        return loB;
    }
}