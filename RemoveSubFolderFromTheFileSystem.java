class RemoveSubFolderFromTheFileSystem {
   
   // Simple node class to build trie (N-ary tree)
   class Node{
        Map<String, Node> children = new HashMap<>();
        String folder;
    }
    
	//roor of trie
    Node root = new Node();
    
	// Take the input directory and push into trie.
    private void insert(String dir){
        Node node = root;
		// This way of split will split based on "\" and also includes it in array.
		// example: "/a/b/c/d" will return ["/a", "/b", "/c", "/d"]
        for(String subDir: dir.split("(?=/)")){
            node.children.putIfAbsent(subDir, new Node());
            node = node.children.get(subDir);
        }
        node.folder = dir;
    }
    
	// Traverse the tree and as soon as you find first parent directory, add that to the result and ignore remaining subDirectories (if any)
    private void removeSubFolder(Node root,List<String> result){
        for(String dir: root.children.keySet()){
            Node node = root.children.get(dir);
            // Add to the result and ignore subDirs
			if(node.folder != null){
               result.add(node.folder);
                continue;
            }
            removeSubFolder(node, result);
        }
    }
    
    public List<String> removeSubfolders(String[] folder) {
        for(String each: folder)
            insert(each);
        List<String> result = new ArrayList<>();
        removeSubFolder(root, result);
        return result;
    }
}