import java.util.HashMap;

/*
 * @lc app=leetcode id=106 lang=java
 *
 * [106] Construct Binary Tree from Inorder and Postorder Traversal
 *
 * https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/description/
 *
 * algorithms
 * Medium (44.10%)
 * Likes:    1461
 * Dislikes: 32
 * Total Accepted:    208.9K
 * Total Submissions: 469.7K
 * Testcase Example:  '[9,3,15,20,7]\n[9,15,7,20,3]'
 *
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 * 
 * Note:
 * You may assume that duplicates do not exist in the tree.
 * 
 * For example, given
 * 
 * 
 * inorder = [9,3,15,20,7]
 * postorder = [9,15,7,20,3]
 * 
 * Return the following binary tree:
 * 
 * 
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
 * 
 * 
 */

// @lc code=start
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
    HashMap<Integer, Integer> temp = new HashMap<>();
    int[] pos;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) {
            temp.put(inorder[i], i);
        }
        pos = postorder;
        TreeNode root = helper(0, inorder.length - 1, 0, postorder.length - 1);
        return root;
    }
    private TreeNode helper(int iStart, int iEnd, int pStart, int pEnd) {
        if (iEnd < iStart || pEnd < pStart) {
            return null;
        }
        int root = pos[pEnd];
        int rootIndex = temp.get(root);
        TreeNode node = new TreeNode(root);
        node.left = helper(iStart, rootIndex - 1, pStart, pStart + rootIndex - iStart - 1);
        node.right = helper(rootIndex + 1, iEnd, pStart + rootIndex - iStart, pEnd - 1);
        return node;
    }
}
// @lc code=end

