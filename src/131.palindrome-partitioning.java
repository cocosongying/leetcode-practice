import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/*
 * @lc app=leetcode id=131 lang=java
 *
 * [131] Palindrome Partitioning
 *
 * https://leetcode.com/problems/palindrome-partitioning/description/
 *
 * algorithms
 * Medium (45.75%)
 * Likes:    1674
 * Dislikes: 61
 * Total Accepted:    219K
 * Total Submissions: 473.9K
 * Testcase Example:  '"aab"'
 *
 * Given a string s, partition s such that every substring of the partition is
 * a palindrome.
 * 
 * Return all possible palindrome partitioning of s.
 * 
 * Example:
 * 
 * 
 * Input: "aab"
 * Output:
 * [
 * ⁠ ["aa","b"],
 * ⁠ ["a","a","b"]
 * ]
 * 
 * 
 */

// @lc code=start
class Solution {
    public List<List<String>> partition(String s) {
        int len = s.length();
        List<List<String>> result = new ArrayList<>();
        if (len == 0) {
            return result;
        }
        boolean[][] dp = new boolean[len][len];
        for (int right = 0; right < len; right++) {
            for (int left = 0; left <= right; left++) {
                if (s.charAt(left) == s.charAt(right)
                && (right - left <= 2 || dp[left + 1][right -1])) {
                    dp[left][right] = true;
                }
            }
        }
        Deque<String> stack = new ArrayDeque<>();
        helper(s, 0, len, dp, stack, result);
        return result;
    }
    private void helper(String s, int start, int len, boolean[][] dp, Deque<String> path, List<List<String>> result) {
        if (start == len) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < len; i++) {
            if (!dp[start][i]) {
                continue;
            }
            path.addLast(s.substring(start, i + 1));
            helper(s, i + 1, len, dp, path, result);
            path.removeLast();
        }
    }
}
// @lc code=end

