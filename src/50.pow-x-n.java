/*
 * @lc app=leetcode id=50 lang=java
 *
 * [50] Pow(x, n)
 *
 * https://leetcode.com/problems/powx-n/description/
 *
 * algorithms
 * Medium (29.28%)
 * Likes:    1279
 * Dislikes: 2794
 * Total Accepted:    433K
 * Total Submissions: 1.5M
 * Testcase Example:  '2.00000\n10'
 *
 * Implement pow(x, n), which calculates x raised to the power n (x^n).
 * 
 * Example 1:
 * 
 * 
 * Input: 2.00000, 10
 * Output: 1024.00000
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: 2.10000, 3
 * Output: 9.26100
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: 2.00000, -2
 * Output: 0.25000
 * Explanation: 2^-2 = 1/2^2 = 1/4 = 0.25
 * 
 * 
 * Note:
 * 
 * 
 * -100.0 < x < 100.0
 * n is a 32-bit signed integer, within the range [−2^31, 2^31 − 1]
 * 
 * 
 */

// @lc code=start
class Solution {
    public double myPow(double x, int n) {
        long powerN = n;
        if (powerN < 0) {
            x = 1 / x;
            powerN = -powerN;
        }
        double result = 1;
        double temp = x;
        for (long i = powerN; i > 0; i /= 2) {
            if ((i % 2) == 1) {
                result *= temp;
            }
            temp *= temp;
        }
        return result;
    }
}
// @lc code=end

