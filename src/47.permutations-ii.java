import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode id=47 lang=java
 *
 * [47] Permutations II
 *
 * https://leetcode.com/problems/permutations-ii/description/
 *
 * algorithms
 * Medium (44.92%)
 * Likes:    1687
 * Dislikes: 58
 * Total Accepted:    327.7K
 * Total Submissions: 729.1K
 * Testcase Example:  '[1,1,2]'
 *
 * Given a collection of numbers that might contain duplicates, return all
 * possible unique permutations.
 * 
 * Example:
 * 
 * 
 * Input: [1,1,2]
 * Output:
 * [
 * ⁠ [1,1,2],
 * ⁠ [1,2,1],
 * ⁠ [2,1,1]
 * ]
 * 
 * 
 */

// @lc code=start
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int[] visited = new int[nums.length];
        Arrays.sort(nums);
        backtrack(result, nums, new ArrayList<Integer>(), visited);
        return result;
    }
    private void backtrack(List<List<Integer>> result, int[] nums, ArrayList<Integer> list, int[] visited) {
        if (list.size() == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] == 1 || (i > 0 && visited[i - 1] == 1 && nums[i] == nums[i - 1])) {
                continue;
            }
            visited[i] = 1;
            list.add(nums[i]);
            backtrack(result, nums, list, visited);
            visited[i] = 0;
            list.remove(list.size() - 1);
        }
    }
}
// @lc code=end

