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
    private int preorderIndex = 0;
    private int inorderIndex = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null) {
            return null;
        }
        return build(preorder, inorder, Integer.MAX_VALUE);
    }

    private TreeNode build(int[] preorder, int[] inorder, int limit) {
        if (preorderIndex >= preorder.length || inorder[inorderIndex] == limit) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[preorderIndex++]);
        root.left = build(preorder, inorder, root.val);
        inorderIndex++;
        root.right = build(preorder, inorder, limit);

        return root;
    }
}
