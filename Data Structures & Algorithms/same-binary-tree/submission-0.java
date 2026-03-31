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
        if (p == null && q == null) return true;
        Deque<TreeNode> pQueue = new LinkedList<>();
        Deque<TreeNode> qQueue = new LinkedList<>();

        pQueue.offerLast(p);
        qQueue.offerLast(q);

        while (!pQueue.isEmpty() && !qQueue.isEmpty()) {
            TreeNode currP = pQueue.pollFirst();
            TreeNode currQ = qQueue.pollFirst();

            if (currP == null && currQ == null) continue;

            if (currP == null && currQ != null) return false;
            else if (currP != null && currQ == null) return false;
            else if (currP.val != currQ.val) return false;

            pQueue.offerLast(currP.left);
            pQueue.offerLast(currP.right);
            qQueue.offerLast(currQ.left);
            qQueue.offerLast(currQ.right);
        }

        if (!pQueue.isEmpty() || !qQueue.isEmpty()) return false;
        return true;
    }
}
