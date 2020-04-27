/*
 * @lc app=leetcode id=34 lang=java
 *
 * [34] Find First and Last Position of Element in Sorted Array
 *
 * https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/
 *
 * algorithms
 * Medium (35.42%)
 * Likes:    2930
 * Dislikes: 133
 * Total Accepted:    456.4K
 * Total Submissions: 1.3M
 * Testcase Example:  '[5,7,7,8,8,10]\n8'
 *
 * Given an array of integers nums sorted in ascending order, find the starting
 * and ending position of a given target value.
 * 
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * 
 * If the target is not found in the array, return [-1, -1].
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 * 
 */

// @lc code=start
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};
        int first = getIndexOfTarget(nums, target, true);
        if (first == nums.length || nums[first] != target) {
            return result;
        }
        result[0] = first;
        result[1] = getIndexOfTarget(nums, target, false) - 1;
        return result;
    }
    private int getIndexOfTarget(int[] nums, int target, boolean first) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] > target || (first && nums[mid] == target)) {
                right = mid;
            } else {
                left  = mid + 1;
            }
        }
        return left;
    }
}
// @lc code=end

