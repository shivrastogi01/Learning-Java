class AllNodesDistanceAtKInBinaryTree {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
    
        List<Integer> result = new ArrayList<>();
        
        findNodesAtDistance(root, target, result, k);
        return result;
    }
    
    int findNodesAtDistance(TreeNode node, TreeNode target, List<Integer> result, int k){
        if(node == target){
             
            if(k == 0){
                result.add(node.val);
                return -1;
            }
            if(target.left == null && target.right == null)
                return 1;
            if(target.left != null)
                checkNodesAtDistance(1, k, target.left, result);
            if(target.right != null)
                checkNodesAtDistance(1, k, target.right, result);
            return 1; // above node is 1 away
        }       
        int leftDistance = -1;
        if(node.left != null)
            leftDistance = findNodesAtDistance(node.left, target, result, k);
        if(leftDistance == k){
            result.add(node.val);
            return leftDistance+1;
        }
        if(leftDistance != -1 && leftDistance < k && node.right != null){
            checkNodesAtDistance(leftDistance +1, k, node.right, result);
        } 
        if(leftDistance != -1)
            return leftDistance+1;
        
        int rightDistance = -1;
        if(node.right != null)
            rightDistance = findNodesAtDistance(node.right, target, result, k);
        if(rightDistance == k){
            result.add(node.val);
            return rightDistance+1;
        }
        
        if(rightDistance != -1 && rightDistance < k && node.left != null){
            checkNodesAtDistance(rightDistance +1, k, node.left, result);
        }
        if(rightDistance== -1)
            return -1;
        return rightDistance +1;
        
    }
     
    void checkNodesAtDistance(int currentDistance, int targetDistance, TreeNode node, List<Integer> result){
        if(currentDistance == targetDistance){
            result.add(node.val);
            return;
        }
        if(currentDistance > targetDistance)
            return;
        if(node.left != null){
            checkNodesAtDistance(currentDistance +1, targetDistance, node.left, result);
        }
        if(node.right != null){
            checkNodesAtDistance(currentDistance +1, targetDistance, node.right, result);
        }   
    }
    
}