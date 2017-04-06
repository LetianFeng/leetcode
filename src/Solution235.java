/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution235 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null)
            return null;

        if (root.val > p.val && root.val > q.val)
            return lowestCommonAncestor(root.left, p, q);
        if (root.val < p.val && root.val < q.val)
            return lowestCommonAncestor(root.right, p, q);
        if (root.val == p.val)
            return parentOfChild(root, q) ? root : null;
        if (root.val == q.val)
            return parentOfChild(root, p) ? root : null;

        return parentOfChild(root, p) && parentOfChild(root, q) ? root : null;
    }

    private boolean parentOfChild(TreeNode root, TreeNode child) {
        if (root == child)
            return true;

        if (root.val > child.val)
            return parentOfChild(root.left, child);
        else
            return parentOfChild(root.right, child);
    }
}