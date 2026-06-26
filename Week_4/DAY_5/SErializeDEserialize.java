
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "";

        StringBuilder data = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            TreeNode node = q.poll();

            if (node == null) {
                data.append("n,");
                continue;
            }

            data.append(node.val).append(",");

            q.offer(node.left);
            q.offer(node.right);
        }

        return data.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) {
            return null;
        }

        // String looks like: "1,2,3,n,n,4,5,n,n,n,n,"
        String[] parts = data.split(",");

        TreeNode root = new TreeNode(Integer.parseInt(parts[0]));
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        int i = 1;

        while (!q.isEmpty() && i < parts.length) {

            TreeNode parent = q.poll();

            // Left child
            if (i < parts.length && !parts[i].equals("n")) {
                TreeNode left = new TreeNode(Integer.parseInt(parts[i]));
                parent.left = left;
                q.offer(left);
            }
            i++;

            // Right child
            if (i < parts.length && !parts[i].equals("n")) {
                TreeNode right = new TreeNode(Integer.parseInt(parts[i]));
                parent.right = right;
                q.offer(right);
            }
            i++;
        }

        return root;
    }
}
