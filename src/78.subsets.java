import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=78 lang=java
 *
 * [78] Subsets
 *
 * https://leetcode.com/problems/subsets/description/
 *
 * algorithms
 * Medium (59.18%)
 * Likes:    3237
 * Dislikes: 75
 * Total Accepted:    522K
 * Total Submissions: 881.5K
 * Testcase Example:  '[1,2,3]'
 *
 * Given a set of distinct integers, nums, return all possible subsets (the
 * power set).
 * 
 * Note: The solution set must not contain duplicate subsets.
 * 
 * Example:
 * 
 * 
 * Input: nums = [1,2,3]
 * Output:
 * [
 * ⁠ [3],
 * [1],
 * [2],
 * [1,2,3],
 * [1,3],
 * [2,3],
 * [1,2],
 * []
 * ]
 * 
 */

// @lc code=start
class Solution {
    List<List<Integer>> output  = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        for (int k = 0; k < n + 1; k++) {
            backtrack(0, new ArrayList<>(), nums, n, k);
        }
        return output;
    }
    private void backtrack(int first, ArrayList<Integer> curr, int[] nums, int n, int k) {
        if (curr.size() == k) {
            output.add(new ArrayList<>(curr));
        }
        for (int i = first; i < n; i++) {
            curr.add(nums[i]);
            backtrack(i + 1, curr, nums, n, k);
            curr.remove(curr.size() - 1);
        }
    }
}
// @lc code=end

