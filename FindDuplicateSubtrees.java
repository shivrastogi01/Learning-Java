class FindDuplicateSubtrees
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        Set<String> subTrees= new HashSet();
        Map<String, TreeNode> duplicates = new HashMap();
      
        traverseTree(root, subTrees, duplicates);
        List<TreeNode> nodes = new ArrayList();
        for(String key:duplicates.keySet()){
            nodes.add(duplicates.get(key));
        }
        return nodes;
    }
    public String  traverseTree(TreeNode node, Set<String> subTrees, Map<String, TreeNode> duplicates){
        if(node==null){
            return "";
        }
        String subTree = "" + node.val;
        subTree = subTree + "," + traverseTree(node.left, subTrees, duplicates);
        subTree = subTree + "," + traverseTree(node.right, subTrees, duplicates);
        if(subTrees.contains(subTree)){
            duplicates.put(subTree, node);
        }
        subTrees.add(subTree);   
        return subTree;
    }
}