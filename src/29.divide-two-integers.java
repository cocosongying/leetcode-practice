/*
 * @lc app=leetcode id=29 lang=java
 *
 * [29] Divide Two Integers
 *
 * https://leetcode.com/problems/divide-two-integers/description/
 *
 * algorithms
 * Medium (16.22%)
 * Likes:    1034
 * Dislikes: 4828
 * Total Accepted:    259.2K
 * Total Submissions: 1.6M
 * Testcase Example:  '10\n3'
 *
 * Given two integers dividend and divisor, divide two integers without using
 * multiplication, division and mod operator.
 * 
 * Return the quotient after dividing dividend by divisor.
 * 
 * The integer division should truncate toward zero, which means losing its
 * fractional part. For example, truncate(8.345) = 8 and truncate(-2.7335) =
 * -2.
 * 
 * Example 1:
 * 
 * 
 * Input: dividend = 10, divisor = 3
 * Output: 3
 * Explanation: 10/3 = truncate(3.33333..) = 3.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: dividend = 7, divisor = -3
 * Output: -2
 * Explanation: 7/-3 = truncate(-2.33333..) = -2.
 * 
 * 
 * Note:
 * 
 * 
 * Both dividend and divisor will be 32-bit signed integers.
 * The divisor will never be 0.
 * Assume we are dealing with an environment which could only store integers
 * within the 32-bit signed integer range: [−2^31,  2^31 − 1]. For the purpose
 * of this problem, assume that your function returns 2^31 − 1 when the
 * division result overflows.
 * 
 * 
 */

// @lc code=start
class Solution {
    public int divide(int dividend, int divisor) {
        boolean sign = (dividend > 0) ^ (divisor > 0);
        if (dividend > 0) {
            dividend = opposite(dividend);
        }
        if (divisor > 0) {
            divisor = opposite(divisor);
        }
        if (dividend > divisor) {
            return 0;
        }
        int oDividend = dividend, oDivisor = divisor;
        int ans = -1;
        dividend -= divisor;
        while (dividend <= divisor) {
            ans = ans + ans;
            divisor += divisor;
            dividend -= divisor;
        }
        int result = ans + opposite(divide(oDividend - divisor, oDivisor));
        if (result == Integer.MIN_VALUE) {
            return sign ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        } else {
            return sign ? result : opposite(result);
        }
    }
    private int opposite(int digit) {
        return ~digit + 1;
    }
}
// @lc code=end

