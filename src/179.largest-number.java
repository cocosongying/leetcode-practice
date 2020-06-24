import java.util.Arrays;
import java.util.Comparator;

/*
 * @lc app=leetcode id=179 lang=java
 *
 * [179] Largest Number
 *
 * https://leetcode.com/problems/largest-number/description/
 *
 * algorithms
 * Medium (27.89%)
 * Likes:    1820
 * Dislikes: 215
 * Total Accepted:    178.4K
 * Total Submissions: 629.6K
 * Testcase Example:  '[10,2]'
 *
 * Given a list of non negative integers, arrange them such that they form the
 * largest number.
 * 
 * Example 1:
 * 
 * 
 * Input: [10,2]
 * Output: "210"
 * 
 * Example 2:
 * 
 * 
 * Input: [3,30,34,5,9]
 * Output: "9534330"
 * 
 * 
 * Note: The result may be very large, so you need to return a string instead
 * of an integer.
 * 
 */

// @lc code=start
class Solution {
    public String largestNumber(int[] nums) {
        Integer[] n = new Integer[nums.length];
        for (int i = 0; i <nums.length; i++) {
            n[i] = nums[i];
        }
        Arrays.sort(n, new Comparator<Integer>() {
            public int compare(Integer n1, Integer n2) {
                String s1 = n1 + "" + n2;
                String s2 = n2 + "" + n1;
                return s2.compareTo(s1);
            }
        });
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < nums.length; i++) {
            sb.append(n[i]);
        }
        String res = sb.toString();
        return res.charAt(0) == '0' ? "0" : res;
    }
}
// @lc code=end

