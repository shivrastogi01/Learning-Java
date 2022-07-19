class InsufficientNodesToLeafPath {
   public  TreeNode sufficientSubset(TreeNode root, int limit) {

		boolean insufficient = isInSufficient(root, 0, limit);
		if (insufficient) {
			root = null;
		}
		return root;
	}

	public  boolean isInSufficient(TreeNode root, int inputVal, int limit) {

		boolean ret = true;
		if (root != null) {

			if (root.left == null && root.right == null) {
				if (inputVal + root.val < limit) {
					ret = true;
				} else {
					ret = false;
				}
			} else {
				boolean isleftInSufficient = isInSufficient(root.left, inputVal + root.val, limit);
				if (isleftInSufficient) {
					root.left = null;
				}
				boolean isRightInSufficient = isInSufficient(root.right, inputVal + root.val, limit);
				if (isRightInSufficient) {
					root.right = null;
				}

				ret = isleftInSufficient && isRightInSufficient;

			}

		}

		return ret;

	}
}