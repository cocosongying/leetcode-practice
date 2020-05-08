import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode id=77 lang=java
 *
 * [77] Combinations
 *
 * https://leetcode.com/problems/combinations/description/
 *
 * algorithms
 * Medium (53.10%)
 * Likes:    1289
 * Dislikes: 63
 * Total Accepted:    272.8K
 * Total Submissions: 513.4K
 * Testcase Example:  '4\n2'
 *
 * Given two integers n and k, return all possible combinations of k numbers
 * out of 1 ... n.
 * 
 * Example:
 * 
 * 
 * Input: n = 4, k = 2
 * Output:
 * [
 * ⁠ [2,4],
 * ⁠ [3,4],
 * ⁠ [2,3],
 * ⁠ [1,2],
 * ⁠ [1,3],
 * ⁠ [1,4],
 * ]
 * 
 * 
 */

// @lc code=start
class Solution {
    List<List<Integer>> output = new LinkedList<>();

    public List<List<Integer>> combine(int n, int k) {
        backtrack(1, new LinkedList<Integer>(), n, k);
        return output;
    }
    private  void backtrack(int first, LinkedList<Integer> curr, int n, int k) {
        if (curr.size() == k) {
            output.add(new LinkedList<Integer>(curr));
        }
        for (int i = first; i < n + 1; i++) {
            curr.add(i);
            backtrack(i + 1, curr, n, k);
            curr.removeLast();
        }
    }
}
// @lc code=end

