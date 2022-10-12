class NoOfGoodLeafNodePair {
    public int countPairs(TreeNode root, int distance) {
        // leaf node -> trail from root to leaf
        Map<TreeNode, List<TreeNode>> map = new HashMap<>();
        List<TreeNode> leaves = new ArrayList<>();
        findLeaves(root, new ArrayList<>(), leaves, map);
        int res = 0;
        // count the distance of each leaf node pairs
        for(int i = 0; i < leaves.size(); i++) {
            for(int j = i + 1; j < leaves.size(); j++) {
                List<TreeNode> list_i = map.get(leaves.get(i));
                List<TreeNode> list_j = map.get(leaves.get(j));
                for(int k = 0; k < Math.min(list_i.size(), list_j.size()); k++) {
                    // Same node in the trail means common ancestor
                    if(list_i.get(k) != list_j.get(k)) {
                        int dist = list_i.size() - k + list_j.size() - k;
                        if(dist <= distance) res++;
                        break;
                    }
                }
            }
        }
        return res;
    }
    
    // DFS find all the leaf nodes.
    private void findLeaves(TreeNode node, List<TreeNode> trail, List<TreeNode> leaves, Map<TreeNode, List<TreeNode>> map) {
        if(node == null) return;
        List<TreeNode> tmp = new ArrayList<>(trail);
        tmp.add(node);
        if(node.left == null && node.right == null) {
            map.put(node, tmp);
            leaves.add(node);
            return;
        }
        findLeaves(node.left, tmp, leaves, map);
        findLeaves(node.right, tmp, leaves, map);
    }
}