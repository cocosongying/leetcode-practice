/*
 * @lc app=leetcode id=79 lang=java
 *
 * [79] Word Search
 *
 * https://leetcode.com/problems/word-search/description/
 *
 * algorithms
 * Medium (34.20%)
 * Likes:    3176
 * Dislikes: 157
 * Total Accepted:    428.6K
 * Total Submissions: 1.3M
 * Testcase Example:  '[["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]]\n"ABCCED"'
 *
 * Given a 2D board and a word, find if the word exists in the grid.
 * 
 * The word can be constructed from letters of sequentially adjacent cell,
 * where "adjacent" cells are those horizontally or vertically neighboring. The
 * same letter cell may not be used more than once.
 * 
 * Example:
 * 
 * 
 * board =
 * [
 * ⁠ ['A','B','C','E'],
 * ⁠ ['S','F','C','S'],
 * ⁠ ['A','D','E','E']
 * ]
 * 
 * Given word = "ABCCED", return true.
 * Given word = "SEE", return true.
 * Given word = "ABCB", return false.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * board and word consists only of lowercase and uppercase English letters.
 * 1 <= board.length <= 200
 * 1 <= board[i].length <= 200
 * 1 <= word.length <= 10^3
 * 
 * 
 */

// @lc code=start
class Solution {
    private static int[][] directs = {{0,1}, {1, 0}, {0, -1}, {-1, 0}};
    private int row, col;
    private boolean hasFind;
    private boolean[][] visited;
    public boolean exist(char[][] board, String word) {
        row = board.length;
        col = board[0].length;
        hasFind = false;
        if (row * col < word.length()) {
            return false;
        }
        visited = new boolean[row][col];
        char[] chars = word.toCharArray();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == chars[0]) {
                    backtrack(board, chars, 1, i, j);
                    if (hasFind) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    private void backtrack(char[][] board, char[] word, int index, int x, int y) {
        if (hasFind) {
            return;
        }
        if (index == word.length) {
            hasFind = true;
            return;
        }
        visited[x][y] = true;
        for (int[] direct : directs) {
            int xn = x + direct[0], yn = y + direct[1];
            if (check(xn, yn) && !visited[xn][yn] && board[xn][yn] == word[index]) {
                backtrack(board, word, index + 1, xn, yn);
            }
        }
        visited[x][y] = false;
    }
    private boolean check(int x, int y) {
        return x >= 0 && x < row && y >=0 && y < col;
    }
}
// @lc code=end

