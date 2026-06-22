class Solution {
    public boolean sameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val != q.val) return false;
        return sameTree(p.left, q.left) && sameTree(p.right, q.right);
    }
}
