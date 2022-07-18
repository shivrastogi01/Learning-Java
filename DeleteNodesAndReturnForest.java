class DeleteNodesAndReturnForest {
List ans = new ArrayList<>();
public void rec(TreeNode root,Set set,boolean del){
if(root == null)return;

 if(set.contains(root.val)){
     rec(root.left,set,true);
     rec(root.right,set,true);
     return;
 }
 
 if(del)ans.add(root);
 rec(root.left,set,false);
 rec(root.right,set,false);
 if(root.left!=null && set.contains(root.left.val))root.left = null;
 if(root.right!=null && set.contains(root.right.val))root.right = null;
}
public List delNodes(TreeNode root, int[] to_delete) {
Set set = new HashSet<>();
for(int x:to_delete)set.add(x);

 rec(root,set,true);
 return ans;
}
}