class SmallestStringStartingFromLeaf {
  public String smallestFromLeaf(TreeNode root) {
        Queue<String> queue = new PriorityQueue<>();
        preorder(root, queue, "");
        return queue.peek();
    }

    private void preorder(TreeNode root, Queue<String> queue, String s) {
        s = Character.toString(root.val + 'a') + s;
        if (root.left == null && root.right == null) {
            queue.offer(s);
        }
        if (root.left != null)
            preorder(root.left, queue, s);
        if (root.right != null)
            preorder(root.right, queue, s);
    }
}