import java.util.HashMap;

/*
 * @lc app=leetcode id=105 lang=java
 *
 * [105] Construct Binary Tree from Preorder and Inorder Traversal
 *
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/
 *
 * algorithms
 * Medium (46.93%)
 * Likes:    3029
 * Dislikes: 86
 * Total Accepted:    339.2K
 * Total Submissions: 716.3K
 * Testcase Example:  '[3,9,20,15,7]\n[9,3,15,20,7]'
 *
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 * 
 * Note:
 * You may assume that duplicates do not exist in the tree.
 * 
 * For example, given
 * 
 * 
 * preorder = [3,9,20,15,7]
 * inorder = [9,3,15,20,7]
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return helper(preorder, 0, preorder.length, inorder, 0, inorder.length, map);
    }
    private TreeNode helper(int[] preorder, int pstart, int pend, 
        int[] inorder, int istart, int iend, HashMap<Integer, Integer> map) {
        if (pstart == pend) {
            return null;
        }
        int rootVal = preorder[pstart];
        TreeNode root = new TreeNode(rootVal);
        int irootIndex = map.get(rootVal);
        int leftNum = irootIndex - istart;
        root.left = helper(preorder, pstart + 1, pstart + leftNum + 1, inorder, istart, irootIndex, map);
        root.right = helper(preorder, pstart + leftNum + 1, pend, inorder, irootIndex + 1, iend, map);
        return root;
    }
}
// @lc code=end

