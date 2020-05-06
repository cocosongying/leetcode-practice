/*
 * @lc app=leetcode id=45 lang=java
 *
 * [45] Jump Game II
 *
 * https://leetcode.com/problems/jump-game-ii/description/
 *
 * algorithms
 * Hard (29.99%)
 * Likes:    2146
 * Dislikes: 121
 * Total Accepted:    238.8K
 * Total Submissions: 796.1K
 * Testcase Example:  '[2,3,1,1,4]'
 *
 * Given an array of non-negative integers, you are initially positioned at the
 * first index of the array.
 * 
 * Each element in the array represents your maximum jump length at that
 * position.
 * 
 * Your goal is to reach the last index in the minimum number of jumps.
 * 
 * Example:
 * 
 * 
 * Input: [2,3,1,1,4]
 * Output: 2
 * Explanation: The minimum number of jumps to reach the last index is 2.
 * ⁠   Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * 
 * Note:
 * 
 * You can assume that you can always reach the last index.
 * 
 */

// @lc code=start
class Solution {
    public int jump(int[] nums) {
        int steps = 0, end = 0, maxP = 0;
        for (int i = 0; i< nums.length - 1; i++) {
            maxP = Math.max(maxP, nums[i] + i);
            if (i == end) {
                end = maxP;
                steps++;
            }
        }
        return steps;
    }
}
// @lc code=end

