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
    public boolean isValidBST(TreeNode root) {
        return isBSTRec(root, -1001, 1001);
    }

    private boolean isBSTRec(TreeNode root, int low, int high) {
        if (root == null) return true;

        boolean isLeftBST = isBSTRec(root.left, low, root.val);
        boolean isRightBST = isBSTRec(root.right, root.val, high);

        return (root.val > low && root.val < high) && isLeftBST && isRightBST;
    }
}
