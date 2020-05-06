import java.util.Arrays;

/*
 * @lc app=leetcode id=41 lang=java
 *
 * [41] First Missing Positive
 *
 * https://leetcode.com/problems/first-missing-positive/description/
 *
 * algorithms
 * Hard (31.14%)
 * Likes:    2985
 * Dislikes: 746
 * Total Accepted:    306.1K
 * Total Submissions: 982.8K
 * Testcase Example:  '[1,2,0]'
 *
 * Given an unsorted integer array, find the smallest missing positive
 * integer.
 * 
 * Example 1:
 * 
 * 
 * Input: [1,2,0]
 * Output: 3
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [3,4,-1,1]
 * Output: 2
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: [7,8,9,11,12]
 * Output: 1
 * 
 * 
 * Note:
 * 
 * Your algorithm should run in O(n) time and uses constant extra space.
 * 
 */

// @lc code=start
class Solution {
    public int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);
        int result = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < result) {
                continue;
            } else if (nums[i] == result) {
                result++;
            } else {
                return result;
            }
        }
        return result;
    }
}
// @lc code=end

