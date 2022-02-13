class BinaryTreeZigzagOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
        List<List<Integer>> out = new ArrayList<List<Integer>> ();
        if (root == null) return out;
        Queue<TreeNode> q = new LinkedList <TreeNode> ();
        q.add (root);
        int reverse = 1;
        while (!q.isEmpty()) {
           int size = q.size ();
           List<Integer> l = new ArrayList<Integer> ();
            for (int i = 0; i < size; i++) {
                
                TreeNode curr =  q.remove ();
                if (reverse == 1) {
                    l.add (curr.val);
                }
                else {
                    l.add (0,curr.val);
                }
                 
                if (curr.left !=null) q.add (curr.left);
                if (curr.right !=null) q.add (curr.right);
            }
            reverse *= -1;
            out.add (l);
        }
        return out;
    }
}