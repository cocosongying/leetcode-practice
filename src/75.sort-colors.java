/*
 * @lc app=leetcode id=75 lang=java
 *
 * [75] Sort Colors
 *
 * https://leetcode.com/problems/sort-colors/description/
 *
 * algorithms
 * Medium (45.30%)
 * Likes:    2791
 * Dislikes: 204
 * Total Accepted:    440.8K
 * Total Submissions: 972.9K
 * Testcase Example:  '[2,0,2,1,1,0]'
 *
 * Given an array with n objects colored red, white or blue, sort them in-place
 * so that objects of the same color are adjacent, with the colors in the order
 * red, white and blue.
 * 
 * Here, we will use the integers 0, 1, and 2 to represent the color red,
 * white, and blue respectively.
 * 
 * Note: You are not suppose to use the library's sort function for this
 * problem.
 * 
 * Example:
 * 
 * 
 * Input: [2,0,2,1,1,0]
 * Output: [0,0,1,1,2,2]
 * 
 * Follow up:
 * 
 * 
 * A rather straight forward solution is a two-pass algorithm using counting
 * sort.
 * First, iterate the array counting number of 0's, 1's, and 2's, then
 * overwrite array with total number of 0's, then 1's and followed by 2's.
 * Could you come up with a one-pass algorithm using only constant space?
 * 
 * 
 */

// @lc code=start
class Solution {
    public void sortColors(int[] nums) {
        int left = 0, current = 0;
        int right = nums.length - 1;
        int temp;
        while (current <= right) {
            if (nums[current] == 0) {
                temp = nums[left];
                nums[left++] = nums[current];
                nums[current++] = temp;
            } else if (nums[current] == 2) {
                temp = nums[current];
                nums[current] = nums[right];
                nums[right--] = temp;
            } else {
                current++;
            }
        }
    }
}
// @lc code=end

