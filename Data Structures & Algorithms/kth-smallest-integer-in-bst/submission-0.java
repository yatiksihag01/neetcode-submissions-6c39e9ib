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

    private void inorder(TreeNode root, ArrayList<Integer> sortedList) {
        if (root == null) return;
        inorder(root.left, sortedList);
        sortedList.add(root.val);
        inorder(root.right, sortedList);
    }

    public int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer> sortedList = new ArrayList();
        inorder(root, sortedList);
        return sortedList.get(k-1);
    }
}
