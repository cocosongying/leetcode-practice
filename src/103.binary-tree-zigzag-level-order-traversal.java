import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode id=103 lang=java
 *
 * [103] Binary Tree Zigzag Level Order Traversal
 *
 * https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/description/
 *
 * algorithms
 * Medium (46.04%)
 * Likes:    1816
 * Dislikes: 98
 * Total Accepted:    338.6K
 * Total Submissions: 730.2K
 * Testcase Example:  '[3,9,20,null,null,15,7]'
 *
 * Given a binary tree, return the zigzag level order traversal of its nodes'
 * values. (ie, from left to right, then right to left for the next level and
 * alternate between).
 * 
 * 
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 * 
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
 * 
 * 
 * 
 * return its zigzag level order traversal as:
 * 
 * [
 * ⁠ [3],
 * ⁠ [20,9],
 * ⁠ [15,7]
 * ]
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<List<Integer>>();
        }
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        dfs(0, root, result);
        return result;
    }
    private void dfs(int index, TreeNode node, List<List<Integer>> res) {
        if (res.size() <= index) {
            LinkedList<Integer> ll = new LinkedList<Integer>();
            ll.add(node.val);
            res.add(ll);
        } else {
            if (index % 2 == 0) {
                res.get(index).add(node.val);
            } else {
                res.get(index).add(0, node.val);
            }
        }
        if (node.left != null) {
            dfs(index + 1, node.left, res);
        }
        if (node.right != null) {
            dfs(index + 1, node.right, res);
        }
    }
}
// @lc code=end

