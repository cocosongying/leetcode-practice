import java.util.Arrays;

/*
 * @lc app=leetcode id=56 lang=java
 *
 * [56] Merge Intervals
 *
 * https://leetcode.com/problems/merge-intervals/description/
 *
 * algorithms
 * Medium (38.38%)
 * Likes:    3607
 * Dislikes: 263
 * Total Accepted:    542.2K
 * Total Submissions: 1.4M
 * Testcase Example:  '[[1,3],[2,6],[8,10],[15,18]]'
 *
 * Given a collection of intervals, merge all overlapping intervals.
 * 
 * Example 1:
 * 
 * 
 * Input: [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into
 * [1,6].
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 * 
 * NOTE: input types have been changed on April 15, 2019. Please reset to
 * default code definition to get new method signature.
 * 
 */

// @lc code=start
class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (v1, v2) -> v1[0] - v2[0]);
        int[][] result = new int[intervals.length][2];
        int index = -1;
        for (int[] interval : intervals) {
            if (index == -1 || interval[0] > result[index][1]) {
                result[++index] = interval;
            } else {
                result[index][1] = Math.max(result[index][1], interval[1]);
            }
        }
        return Arrays.copyOf(result, index + 1);
    }
}
// @lc code=end

