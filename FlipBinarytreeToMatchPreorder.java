class FlipBinarytreeToMatchPreorder {
  int piv = 0;
  public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
    List<Integer> ret = new ArrayList<>();
    return helper(root, voyage, ret) ? ret : Arrays.asList(-1);
  }

  boolean helper(TreeNode node, int[] arr, List<Integer> ret) {
    if (node == null) { return true; }
    // This is important, whether swap has occurred or not, we expect the value of the current node(the root of its subtree) to be arr[piv], or else we abort and call mission failure.
    if (node.val != arr[piv]) {
      return false;
    }
    piv++;
    if (node.left != null && node.left.val != arr[piv]) {
      // we have to swap here by going into the right subtree first, and expect the right-first-then-left preorder traversal meets the requirement posed by arr[piv]
      ret.add(node.val);
      return helper(node.right, arr, ret) && helper(node.left, arr, ret);
    }
    // No swap, going into the left subtree and expect left-first-then-right preorder traversal meets the requirement posed by arr[piv]
    return helper(node.left, arr, ret) && helper(node.right, arr, ret);
  }
}