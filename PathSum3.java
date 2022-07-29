class PathSum3 {
    public int pathSum(TreeNode root, int targetSum) {
        return pathSum(root, targetSum, new ArrayList<>());
    }

    public int pathSum(TreeNode root, long targetSum, List<Integer> path) {

        if (root == null) return 0;

        path.add(root.val);

        int pathCount = 0;
        long sum = 0;
        for (int i = path.size() - 1; i >= 0; i--) {
            sum += path.get(i);
            if (sum == targetSum) pathCount += 1;
        }

        pathCount += pathSum(root.left, targetSum, path);
        pathCount += pathSum(root.right, targetSum, path);

        path.remove(path.size() - 1);

        return pathCount;
    }
}