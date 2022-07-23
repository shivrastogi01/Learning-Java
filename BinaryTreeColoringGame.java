/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class BinaryTreeColoringGame {
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
  	    TreeNode firstPlayerNode = locate(root,x);
    	
    	// calculate nodes in its left subtree 
    	int l= calculateSize(firstPlayerNode.left);
    	// calculate nodes in its right subtree
    	int r = calculateSize(firstPlayerNode.right);
    	

    	int remaining = n-l-r-1;
    	
    	if(remaining>(l+r+1)){
    		return true;
    	}else if(l>(remaining+r+1)){
    		return true;
    	}else if(r>(remaining+l+1)){
    		return true;
    	}
    	
    	return false;        
    }
    
    public  int calculateSize(TreeNode root){
    	
    	int count=0;
    	if(root!=null){
    		if(root.left==null && root.right==null){
    			return 1;
    		}
    		count = 1 + calculateSize(root.left);
			count = count+calculateSize(root.right);
    	}
    	return count;
    }
    
	public  TreeNode locate(TreeNode root, int x){
		TreeNode ret=null;
    	if(root!=null){
    		if(root.val==x){
    			return root;
    		}
        	ret=locate(root.left,x);
        	if(ret==null){
        		ret=locate(root.right,x);	
        	}
        	
    	}
    	
    	return ret;
    }
}