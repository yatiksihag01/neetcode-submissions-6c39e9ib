/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int pv = p.val, qv = q.val, rv = root.val;

        if (pv < rv && qv < rv) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (pv > rv && qv > rv) {
            return lowestCommonAncestor(root.right, p, q);
        } else {
            return root;
        }
    }
}
