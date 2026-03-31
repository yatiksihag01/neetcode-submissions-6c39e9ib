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
    private final HashMap<Integer, Integer> indexMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) indexMap.put(inorder[i], i);
        return buildTreeRec(preorder, 0, inorder.length - 1); 
    }

    private TreeNode buildTreeRec(int[] preorder, int left, int right) {
        if (left > right) return null;
        int rootVal = preorder[preorderIndex++];
        TreeNode root = new TreeNode(rootVal);

        int mid = indexMap.get(rootVal);
        root.left = buildTreeRec(preorder, left, mid - 1);
        root.right = buildTreeRec(preorder, mid + 1, right);

        return root;
    }
}
