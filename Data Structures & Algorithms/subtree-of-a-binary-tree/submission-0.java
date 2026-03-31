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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        Deque<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.removeFirst();
            if (node == null) continue;
            int val = node.val;

            if (val == subRoot.val) {
                boolean isSubtree = compareTrees(node, subRoot);
                if (isSubtree) return true;
            }

            queue.addLast(node.left);
            queue.addLast(node.right);
        }
        return false;
    }

    private boolean compareTrees(TreeNode a, TreeNode b) {
        Deque<TreeNode> queue = new LinkedList<>();
        queue.addLast(a);
        queue.addLast(b);

        while (!queue.isEmpty()) {
            TreeNode nodeA = queue.removeFirst();
            TreeNode nodeB = queue.removeFirst();

            if (nodeA == null && nodeB == null) continue;
            if (nodeA == null || nodeB == null) return false;
            if (nodeA.val != nodeB.val) return false;

            queue.addLast(nodeA.left);
            queue.addLast(nodeB.left);

            queue.addLast(nodeA.right);
            queue.addLast(nodeB.right);
        }
        return true;
    }
}
