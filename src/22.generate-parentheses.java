import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=22 lang=java
 *
 * [22] Generate Parentheses
 *
 * https://leetcode.com/problems/generate-parentheses/description/
 *
 * algorithms
 * Medium (60.78%)
 * Likes:    4530
 * Dislikes: 245
 * Total Accepted:    504K
 * Total Submissions: 829.2K
 * Testcase Example:  '3'
 *
 * 
 * Given n pairs of parentheses, write a function to generate all combinations
 * of well-formed parentheses.
 * 
 * 
 * 
 * For example, given n = 3, a solution set is:
 * 
 * 
 * [
 * ⁠ "((()))",
 * ⁠ "(()())",
 * ⁠ "(())()",
 * ⁠ "()(())",
 * ⁠ "()()()"
 * ]
 * 
 */

// @lc code=start
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, new StringBuilder(), 0, 0, n);
        return result;
    }
    private void backtrack(List<String> result, StringBuilder parentheses, int left, int right, int max) {
        if (parentheses.length() == max * 2) {
            result.add(parentheses.toString());
            return;
        }
        if (left < max) {
            parentheses.append('(');
            backtrack(result, parentheses, left + 1, right, max);
            parentheses.deleteCharAt(parentheses.length() - 1);
        }
        if (right < left) {
            parentheses.append(')');
            backtrack(result, parentheses, left, right + 1, max);
            parentheses.deleteCharAt(parentheses.length() - 1);
        }
    }
}
// @lc code=end

