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
    public int goodNodes(TreeNode root) {
        return goodNodesRec(root, -101);
    }

    private int goodNodesRec(TreeNode root, int ceil) {
        if (root == null) return 0;
        int count = 0;
        
        if (root.val >= ceil) {
            count++;
            ceil = root.val;
        }
        return count + goodNodesRec(root.left, ceil) + goodNodesRec(root.right, ceil);
    }
}
