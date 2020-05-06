/*
 * @lc app=leetcode id=59 lang=java
 *
 * [59] Spiral Matrix II
 *
 * https://leetcode.com/problems/spiral-matrix-ii/description/
 *
 * algorithms
 * Medium (52.13%)
 * Likes:    843
 * Dislikes: 103
 * Total Accepted:    181.3K
 * Total Submissions: 347.6K
 * Testcase Example:  '3'
 *
 * Given a positive integer n, generate a square matrix filled with elements
 * from 1 to n^2 in spiral order.
 * 
 * Example:
 * 
 * 
 * Input: 3
 * Output:
 * [
 * ⁠[ 1, 2, 3 ],
 * ⁠[ 8, 9, 4 ],
 * ⁠[ 7, 6, 5 ]
 * ]
 * 
 * 
 */

// @lc code=start
class Solution {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int top = 0, bottom = n - 1;
        int left = 0, right = n - 1;
        int num = 1, max = n * n;
        while (num <= max) {
            for (int i = left; i <= right; i++) {
                result[top][i] = num++;
            }
            for (int i = top + 1; i <= bottom; i++) {
                result[i][right] = num++;
            }
            for (int i = right - 1; i > left; i--) {
                result[bottom][i] = num++;
            }
            for (int i = bottom; i > top; i--) {
                result[i][left] = num++;
            }
            top++;
            bottom--;
            left++;
            right--;
        }
        return result;
    }
}
// @lc code=end

