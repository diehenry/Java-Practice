package leetcode;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    // i = 0 start
    public TreeNode createNode(Integer[] treeArr, int i) {
        if (i >= treeArr.length || treeArr[i] == null) {
            return null;
        }

        TreeNode p = new TreeNode(treeArr[i]);
        p.left = createNode(treeArr, i * 2 + 1);
        p.right = createNode(treeArr, i * 2 + 2);
        return p;
    }
}
