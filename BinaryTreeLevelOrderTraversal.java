class BinaryTreeLevelOrderTraversal{
    public List<List<Integer>> levelOrder(TreeNode root){
       List<List<Integer>> ans = new ArrayList<>();
       if(root == null)return ans; 
        
       Queue<TreeNode> q = new LinkedList<>();
       q.offer(root);
       int count = 1;
      
      List<Integer> ls = new ArrayList<>();  
      while(q.size() > 0){
       TreeNode temp = q.poll();
       count--;
       ls.add(temp.val);
          
       if(temp.left != null)q.offer(temp.left); 
       if(temp.right != null)q.offer(temp.right);
          
       if(count == 0){
         ans.add(ls);
         count=q.size();
         ls = new ArrayList<>();  
       }  
      }
     return ans;    
    }
    }