/*
 * @lc app=leetcode id=125 lang=java
 *
 * [125] Valid Palindrome
 *
 * https://leetcode.com/problems/valid-palindrome/description/
 *
 * algorithms
 * Easy (34.95%)
 * Likes:    1110
 * Dislikes: 2792
 * Total Accepted:    556.8K
 * Total Submissions: 1.6M
 * Testcase Example:  '"A man, a plan, a canal: Panama"'
 *
 * Given a string, determine if it is a palindrome, considering only
 * alphanumeric characters and ignoring cases.
 * 
 * Note: For the purpose of this problem, we define empty string as valid
 * palindrome.
 * 
 * Example 1:
 * 
 * 
 * Input: "A man, a plan, a canal: Panama"
 * Output: true
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: "race a car"
 * Output: false
 * 
 * 
 */

// @lc code=start
class Solution {
    public boolean isPalindrome(String s) {
        if (s.length() <= 1) {
            return true;
        }
        s = s.toLowerCase();
        int i = 0, j = s.length() - 1;
        while (i < j) {
            char left = s.charAt(i);
            if (!Character.isLetterOrDigit(left)) {
                i++;
                continue;
            }
            char right = s.charAt(j);
            if (!Character.isLetterOrDigit(right)) {
                j--;
                continue;
            }
            if (left != right) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
// @lc code=end

