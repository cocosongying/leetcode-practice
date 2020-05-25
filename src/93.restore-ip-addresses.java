import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode id=93 lang=java
 *
 * [93] Restore IP Addresses
 *
 * https://leetcode.com/problems/restore-ip-addresses/description/
 *
 * algorithms
 * Medium (34.46%)
 * Likes:    1143
 * Dislikes: 478
 * Total Accepted:    184.8K
 * Total Submissions: 532.3K
 * Testcase Example:  '"25525511135"'
 *
 * Given a string containing only digits, restore it by returning all possible
 * valid IP address combinations.
 * 
 * A valid IP address consists of exactly four integers (each integer is
 * between 0 and 255) separated by single points.
 * 
 * Example:
 * 
 * 
 * Input: "25525511135"
 * Output: ["255.255.11.135", "255.255.111.35"]
 * 
 * 
 */

// @lc code=start
class Solution {
    int n;
    String s;
    LinkedList<String> ll = new LinkedList<>();
    ArrayList<String> result = new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {
        n = s.length();
        this.s = s;
        backtrack(-1, 3);
        return result;
    }
    private void backtrack(int pos, int dots) {
        int max = Math.min(n - 1, pos + 4);
        for (int curr = pos + 1; curr < max; curr++) {
            String seg = s.substring(pos + 1, curr + 1);
            if (valid(seg)) {
                ll.add(seg);
                if (dots - 1 == 0) {
                    addResult(curr);
                } else {
                    backtrack(curr, dots - 1);
                }
                ll.removeLast();
            }
        }
    }
    private boolean valid(String seg) {
        int m = seg.length();
        if (m > 3) {
            return false;
        }
        return (seg.charAt(0) != '0') ? (Integer.valueOf(seg) <= 255) : (m == 1);
    }
    private void addResult(int curr) {
        String seg = s.substring(curr + 1, n);
        if (valid(seg)) {
            ll.add(seg);
            result.add(String.join(".", ll));
            ll.removeLast();
        }
    }
}
// @lc code=end

