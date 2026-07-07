package leetcode;

public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // identical
        if (p == null && q == null) {
            return true;
        }

        // only one of them is null, can't be identical
        if (p == null || q == null || p.val != q.val) {
            return false;
        }

        // pre-order (DLR)
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);

    }
}
