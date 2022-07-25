class MaximumLevelSumBinaryTree {
    public int maxLevelSum(TreeNode root) {

        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        
        int level = 0, maxSum= -100001, currSum = 0, maxLevel = 0;
        
        while(!q.isEmpty()){
            
            TreeNode currNode = q.remove();
            if(currNode == null){
                level++;
                if(currSum>maxSum){
                    maxSum = currSum;
                    maxLevel = level;
                }
                currSum = 0;
                
                if(q.isEmpty())
                    break;
                else
                    q.add(null);    
            }
            else{
                currSum = currSum+currNode.val;
                if(currNode.left!=null)
                    q.add(currNode.left);
                if(currNode.right!=null)
                    q.add(currNode.right);
            }   
        }
        return maxLevel;
    }
}