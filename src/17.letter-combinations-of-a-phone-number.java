import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=17 lang=java
 *
 * [17] Letter Combinations of a Phone Number
 *
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/
 *
 * algorithms
 * Medium (45.50%)
 * Likes:    3448
 * Dislikes: 382
 * Total Accepted:    561.7K
 * Total Submissions: 1.2M
 * Testcase Example:  '"23"'
 *
 * Given a string containing digits from 2-9 inclusive, return all possible
 * letter combinations that the number could represent.
 * 
 * A mapping of digit to letters (just like on the telephone buttons) is given
 * below. Note that 1 does not map to any letters.
 * 
 * 
 * 
 * Example:
 * 
 * 
 * Input: "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 
 * 
 * Note:
 * 
 * Although the above answer is in lexicographical order, your answer could be
 * in any order you want.
 * 
 */

// @lc code=start
class Solution {
    List<String> result = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        if (digits.length() > 0) {
            backtrack("", digits);
        }
        return result;
    }
    private void backtrack(String combination, String digits) {
        if (digits.length() == 0) {
            result.add(combination);
        } else {
            char digit = digits.charAt(0);
            String letters = getLetters(digit);
            for (int i = 0; i < letters.length(); i++) {
                String letter = String.valueOf(letters.charAt(i));
                backtrack(combination + letter, digits.substring(1));
            }
        }
    }
    private String getLetters(char digit) {
        switch(digit) {
            case '2': return "abc";
            case '3': return "def";
            case '4': return "ghi";
            case '5': return "jkl";
            case '6': return "mno";
            case '7': return "pqrs";
            case '8': return "tuv";
            case '9': return "wxyz";
            default: return "";
        }
    }
}
// @lc code=end

