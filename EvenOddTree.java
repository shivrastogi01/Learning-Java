class EvenOddTree {
    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int size = queue.size(), level = 0;
        TreeNode pre = null;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (level % 2 == node.val % 2) return false;
            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
            if (pre != null) {
                if ((level % 2 == 0 && node.val <= pre.val) ||
                    (level % 2 != 0 && node.val >= pre.val)) return false;
            }
            pre = node;
            size--;
            if (size == 0) {
                pre = null;
                level++;
                size = queue.size();
            }
        }
        return true;
    }
}