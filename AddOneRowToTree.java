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
class AddOneRowToTree {
   public TreeNode addOneRow(TreeNode root, int val, int depth) {
       if (depth == 1) {
            TreeNode node = new TreeNode(val);
            node.left = root;
            return node;
        }
        recur(root, val, depth);
        return root;
    }
    
    public void recur(TreeNode root, int val, int depth){
        if(root == null) return;
        if(depth == 2){
            TreeNode left = new TreeNode(val);
            TreeNode right = new TreeNode(val);
            TreeNode temp = root.left;
            TreeNode temp2 = root.right;
            root.left = left;
            root.right = right;
            
            left.left = temp;
            right.right = temp2;
        }else{
            recur(root.left, val, depth-1);
            recur(root.right, val, depth-1);
        }
    }
}