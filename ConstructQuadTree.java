class ConstructQuadTree {
    public Node construct(int[][] grid) {
        return buildTree(grid, 0, 0, grid.length);
    }
    
    private Node buildTree(int[][] grid, int topLeftRow, int topLeftCol, int size){
        
        if (size == 1){//Base Case
            return new Node(grid[topLeftRow][topLeftCol] == 1, true);
        }
        
        //Recursion by splitting the grid into 4 parts
        
        int newSize = size / 2;
        
        Node topLeftNode = buildTree(grid, topLeftRow, topLeftCol, newSize);
        Node topRightNode = buildTree(grid, topLeftRow, topLeftCol + newSize, newSize);
        Node bottomLeftNode = buildTree(grid, topLeftRow + newSize, topLeftCol, newSize);
        Node bottomRightNode = buildTree(grid, topLeftRow + newSize, topLeftCol + newSize, newSize);
        
        //If all 4 parts return as leaf node *AND* have the same value then merge them into one

        if (checkIfAllSameLeaf(topLeftNode, topRightNode, bottomLeftNode, bottomRightNode)){
            return new Node(topLeftNode.val, true);
        }else{
            return new Node(true, false, topLeftNode, topRightNode, bottomLeftNode, bottomRightNode);
        }
        
    }
    
    private boolean checkIfAllSameLeaf(Node node1, Node node2, Node node3, Node node4){
        if (node1.isLeaf == true && node1.isLeaf == node2.isLeaf && node2.isLeaf == node3.isLeaf && node3.isLeaf == node4.isLeaf){
            return (node1.val == node2.val && node2.val == node3.val && node3.val == node4.val);
        }
        
        return false;
    }
}