/*
 * @lc app=leetcode id=31 lang=java
 *
 * [31] Next Permutation
 *
 * https://leetcode.com/problems/next-permutation/description/
 *
 * algorithms
 * Medium (32.00%)
 * Likes:    2945
 * Dislikes: 1044
 * Total Accepted:    340.1K
 * Total Submissions: 1.1M
 * Testcase Example:  '[1,2,3]'
 *
 * Implement next permutation, which rearranges numbers into the
 * lexicographically next greater permutation of numbers.
 * 
 * If such arrangement is not possible, it must rearrange it as the lowest
 * possible order (ie, sorted in ascending order).
 * 
 * The replacement must be in-place and use only constant extra memory.
 * 
 * Here are some examples. Inputs are in the left-hand column and its
 * corresponding outputs are in the right-hand column.
 * 
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 * 
 */

// @lc code=start
class Solution {
    public void nextPermutation(int[] nums) {
        int index = nums.length - 2;
        while(index >= 0 && nums[index + 1] <= nums[index]) {
            index--;
        }
        if (index >= 0) {
            int next = nums.length - 1;
            while(next >= 0 && nums[next] <= nums[index]) {
                next--;
            }
            swap(nums, next, index);
        }
        reverse(nums, index + 1);
    }
    private void reverse(int[] nums, int start) {
        int end = nums.length -1;
        while(start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
// @lc code=end

