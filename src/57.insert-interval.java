import java.util.LinkedList;

/*
 * @lc app=leetcode id=57 lang=java
 *
 * [57] Insert Interval
 *
 * https://leetcode.com/problems/insert-interval/description/
 *
 * algorithms
 * Hard (32.87%)
 * Likes:    1401
 * Dislikes: 161
 * Total Accepted:    232K
 * Total Submissions: 705.6K
 * Testcase Example:  '[[1,3],[6,9]]\n[2,5]'
 *
 * Given a set of non-overlapping intervals, insert a new interval into the
 * intervals (merge if necessary).
 * 
 * You may assume that the intervals were initially sorted according to their
 * start times.
 * 
 * Example 1:
 * 
 * 
 * Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
 * Output: [[1,5],[6,9]]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * Output: [[1,2],[3,10],[12,16]]
 * Explanation: Because the new interval [4,8] overlaps with
 * [3,5],[6,7],[8,10].
 * 
 * NOTE: input types have been changed on April 15, 2019. Please reset to
 * default code definition to get new method signature.
 * 
 */

// @lc code=start
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int nStart = newInterval[0], nEnd = newInterval[1];
        int index = 0, len = intervals.length;
        LinkedList<int[]> result = new LinkedList<>();
        while (index < len && nStart > intervals[index][0]) {
            result.add(intervals[index++]);
        }
        int[] temp = new int[2];
        if (result.isEmpty() || result.getLast()[1] < nStart) {
            result.add(newInterval);
        } else {
            temp = result.removeLast();
            temp[1] = Math.max(temp[1], nEnd);
            result.add(temp);
        }
        while (index < len) {
            temp = intervals[index++];
            int start = temp[0], end = temp[1];
            if (result.getLast()[1] < start) {
                result.add(temp);
            } else {
                temp = result.removeLast();
                temp[1] = Math.max(temp[1], end);
                result.add(temp);
            }
        }
        return result.toArray(new int[result.size()][2]);
    }
}
// @lc code=end

