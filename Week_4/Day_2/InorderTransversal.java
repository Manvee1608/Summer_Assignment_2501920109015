class Solution {
    List<Integer> result = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        result.clear();
        in(root);
        return result;
    }

    public void in(TreeNode root) {
        if (root == null) return;

        in(root.left);
        result.add(root.val);
        in(root.right);
    }
}
