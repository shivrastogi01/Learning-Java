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
class FlipEquivalentBinary {
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null) {
            return true;
        }
        if(root1 == null || root2 == null) {
            return false;
        }
        if(root1.val != root2.val){
            return false;
        }
        
        // There are two cases that can return true:
        // 1. r1.r == r2.r && r1.l == r2.l
        // 2. r1.r == r2.l && r1.l == r2.r
               
        int rightVal1 = root1.right != null ? root1.right.val : -1;
        int rightVal2 = root2.right != null ? root2.right.val : -1;
        int leftVal1 = root1.left != null ? root1.left.val : -1;
        int leftVal2 = root2.left != null ? root2.left.val : -1;
        if(rightVal1 == rightVal2 && leftVal1 == leftVal2) {
            return (root1.right == null || flipEquiv(root1.right, root2.right))
                && (root1.left == null || flipEquiv(root1.left, root2.left));
        }
        
        if(rightVal1 == leftVal2 && leftVal1 == rightVal2) {
            return (root1.right == null || flipEquiv(root1.right, root2.left))
                && (root1.left == null || flipEquiv(root1.left, root2.right));
        }
        return false;
    }
}