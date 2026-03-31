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
public boolean isSameTree(TreeNode p, TreeNode q) {
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offerLast(p);
        queue.offerLast(q);

        while (!queue.isEmpty()) {
            TreeNode n1 = queue.pollFirst();
            TreeNode n2 = queue.pollFirst();

            if (n1 == null && n2 == null) continue;
            if (n1 == null || n2 == null || n1.val != n2.val) return false;

            queue.offerLast(n1.left);
            queue.offerLast(n2.left);
            queue.offerLast(n1.right);
            queue.offerLast(n2.right);
        }
        return true;
    }
}
