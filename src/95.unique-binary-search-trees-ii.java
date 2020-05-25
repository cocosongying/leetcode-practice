import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode id=95 lang=java
 *
 * [95] Unique Binary Search Trees II
 *
 * https://leetcode.com/problems/unique-binary-search-trees-ii/description/
 *
 * algorithms
 * Medium (39.32%)
 * Likes:    1985
 * Dislikes: 157
 * Total Accepted:    183.6K
 * Total Submissions: 464.1K
 * Testcase Example:  '3'
 *
 * Given an integer n, generate all structurally unique BST's (binary search
 * trees) that store values 1 ... n.
 * 
 * Example:
 * 
 * 
 * Input: 3
 * Output:
 * [
 * [1,null,3,2],
 * [3,2,null,1],
 * [3,1,null,null,2],
 * [2,1,3],
 * [1,null,2,null,3]
 * ]
 * Explanation:
 * The above output corresponds to the 5 unique BST's shown below:
 * 
 * ⁠  1         3     3      2      1
 * ⁠   \       /     /      / \      \
 * ⁠    3     2     1      1   3      2
 * ⁠   /     /       \                 \
 * ⁠  2     1         2                 3
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
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new LinkedList<TreeNode>();
        }
        return helper(1, n);
    }
    private LinkedList<TreeNode> helper(int start, int end) {
        LinkedList<TreeNode> result = new LinkedList<>();
        if (start > end) {
            result.add(null);
            return result;
        }
        for (int i = start; i <= end; i++) {
            LinkedList<TreeNode> left = helper(start, i - 1);
            LinkedList<TreeNode> right = helper(i + 1, end);
            for (TreeNode l : left) {
                for (TreeNode r : right) {
                    TreeNode curr = new TreeNode(i);
                    curr.left = l;
                    curr.right = r;
                    result.add(curr);
                }
            }
        }
        return result;
    }
}
// @lc code=end

