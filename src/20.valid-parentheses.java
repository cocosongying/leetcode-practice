import java.util.Stack;

/*
 * @lc app=leetcode id=20 lang=java
 *
 * [20] Valid Parentheses
 *
 * https://leetcode.com/problems/valid-parentheses/description/
 *
 * algorithms
 * Easy (38.35%)
 * Likes:    4529
 * Dislikes: 207
 * Total Accepted:    926.9K
 * Total Submissions: 2.4M
 * Testcase Example:  '"()"'
 *
 * Given a string containing just the characters '(', ')', '{', '}', '[' and
 * ']', determine if the input string is valid.
 * 
 * An input string is valid if:
 * 
 * 
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * 
 * 
 * Note that an empty string is also considered valid.
 * 
 * Example 1:
 * 
 * 
 * Input: "()"
 * Output: true
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: "()[]{}"
 * Output: true
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: "(]"
 * Output: false
 * 
 * 
 * Example 4:
 * 
 * 
 * Input: "([)]"
 * Output: false
 * 
 * 
 * Example 5:
 * 
 * 
 * Input: "{[]}"
 * Output: true
 * 
 * 
 */

// @lc code=start
class Solution {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        } else if (s.length() % 2 != 0) {
            return false;
        }
        Stack<Character> inputStrStack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                inputStrStack.push(c);
            } else if (!inputStrStack.isEmpty() && isMatch(inputStrStack.peek(), c)) {
                inputStrStack.pop();
            } else if (inputStrStack.isEmpty() && (c == ')' || c == '}' || c == ']')) {
                return false;
            } else {
                return false;
            }
        }
        return inputStrStack.isEmpty();
    }

    private boolean isMatch(char left, char right) {
        if (left == '(' && right == ')') {
            return true;
        } else if (left == '{' && right == '}') {
            return true;
        } else if (left == '[' && right == ']') {
            return true;
        }
        return false;
    }
}
// @lc code=end

