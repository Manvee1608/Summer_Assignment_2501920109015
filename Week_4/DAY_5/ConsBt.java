
class Solution {

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        Map<Integer, Integer> inOrderIndexMap = new HashMap<>();

        // Store the index of every node in inorder traversal
        for (int i = 0; i < inorder.length; i++) {
            inOrderIndexMap.put(inorder[i], i);
        }

        return splitTree(preorder, inOrderIndexMap, 0, 0, inorder.length - 1);
    }

    private TreeNode splitTree(int[] preorder,
                               Map<Integer, Integer> inOrderIndexMap,
                               int rootIndex,
                               int left,
                               int right) {

        // Base case
        if (left > right) {
            return null;
        }

        // Create root node
        TreeNode root = new TreeNode(preorder[rootIndex]);

        // Find root position in inorder traversal
        int mid = inOrderIndexMap.get(preorder[rootIndex]);

        // Build left subtree
        if (mid > left) {
            root.left = splitTree(
                    preorder,
                    inOrderIndexMap,
                    rootIndex + 1,
                    left,
                    mid - 1
            );
        }

        // Build right subtree
        if (mid < right) {
            root.right = splitTree(
                    preorder,
                    inOrderIndexMap,
                    rootIndex + (mid - left) + 1,
                    mid + 1,
                    right
            );
        }

        return root;
    }
}
