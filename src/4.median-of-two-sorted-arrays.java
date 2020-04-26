/*
 * @lc app=leetcode id=4 lang=java
 *
 * [4] Median of Two Sorted Arrays
 *
 * https://leetcode.com/problems/median-of-two-sorted-arrays/description/
 *
 * algorithms
 * Hard (27.36%)
 * Likes:    6453
 * Dislikes: 985
 * Total Accepted:    635.6K
 * Total Submissions: 2.2M
 * Testcase Example:  '[1,3]\n[2]'
 *
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * 
 * Find the median of the two sorted arrays. The overall run time complexity
 * should be O(log (m+n)).
 * 
 * You may assume nums1 and nums2 cannot be both empty.
 * 
 * Example 1:
 * 
 * 
 * nums1 = [1, 3]
 * nums2 = [2]
 * 
 * The median is 2.0
 * 
 * 
 * Example 2:
 * 
 * 
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * 
 * The median is (2 + 3)/2 = 2.5
 * 
 * 
 */

// @lc code=start
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length, len2 = nums2.length;
        if (len1 > len2) {
            int[] tempArray = nums1;
            nums1 = nums2;
            nums2 = tempArray;
            int tempLen = len1;
            len1 = len2;
            len2 = tempLen;
        }
        int min = 0, max = len1, half = (len1 + len2 + 1) / 2;
        while(min <= max) {
            int i = (min + max) /2;
            int j = half - i;
            if (i < max && nums1[i] < nums2[j - 1]) {
                min = i + 1;
            } else if (i > min && nums1[i-1] > nums2[j]) {
                max = i - 1;
            } else {
                int maxL = 0;
                if (i == 0) {
                    maxL = nums2[j - 1];
                } else if (j == 0) {
                    maxL = nums1[i - 1];
                } else {
                    maxL = Math.max(nums1[i - 1], nums2[j - 1]);
                }
                if ((len1 + len2) % 2 == 1) {
                    return maxL;
                }
                int minR = 0;
                if (i == len1) {
                    minR = nums2[j];
                } else if (j == len2) {
                    minR = nums1[i];
                } else {
                    minR = Math.min(nums1[i], nums2[j]);
                }
                return (maxL + minR) / 2.0;
            }
        }
        return 0.0;
    }
}
// @lc code=end

