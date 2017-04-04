import java.util.LinkedList;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution297 {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null)
            return "";

        StringBuilder result = new StringBuilder();
        result.append(root.val);

        LinkedList<TreeNode> list = new LinkedList<TreeNode>();
        list.add(root.left);
        list.add(root.right);
        while (!list.isEmpty()) {
            TreeNode node = list.removeFirst();
            if (node != null) {
                result.append("," + node.val);
                list.add(node.left);
                list.add(node.right);
            } else
                result.append(",null");
        }
        return result.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals(""))
            return null;


        String[] serializedNodes = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(serializedNodes[0]));

        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(root);

        int size = serializedNodes.length;
        for (int i = 1; i < size - 1; i++) {
            TreeNode parent = list.removeFirst();
            if (!serializedNodes[i].equals("null")) {
                TreeNode left = new TreeNode(Integer.parseInt(serializedNodes[i]));
                parent.left = left;
                list.add(left);
            }
            if (!serializedNodes[++i].equals("null")) {
                TreeNode right = new TreeNode(Integer.parseInt(serializedNodes[i]));
                parent.right = right;
                list.add(right);
            }
        }

        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));