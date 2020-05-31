/*
 * @lc app=leetcode id=130 lang=java
 *
 * [130] Surrounded Regions
 *
 * https://leetcode.com/problems/surrounded-regions/description/
 *
 * algorithms
 * Medium (24.07%)
 * Likes:    1308
 * Dislikes: 578
 * Total Accepted:    196.8K
 * Total Submissions: 759.3K
 * Testcase Example:  '[["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]'
 *
 * Given a 2D board containing 'X' and 'O' (the letter O), capture all regions
 * surrounded by 'X'.
 * 
 * A region is captured by flipping all 'O's into 'X's in that surrounded
 * region.
 * 
 * Example:
 * 
 * 
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * 
 * 
 * After running your function, the board should be:
 * 
 * 
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 * 
 * 
 * Explanation:
 * 
 * Surrounded regions shouldn’t be on the border, which means that any 'O' on
 * the border of the board are not flipped to 'X'. Any 'O' that is not on the
 * border and it is not connected to an 'O' on the border will be flipped to
 * 'X'. Two cells are connected if they are adjacent cells connected
 * horizontally or vertically.
 * 
 */

// @lc code=start
class Solution {
    int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public void solve(char[][] board) {
        if (board == null || board.length == 0
            || board[0] == null || board[0].length == 0) {
            return;
        }
        int row = board.length;
        int col = board[0].length;
        for (int j = 0; j < col; j++) {
            if (board[0][j] == 'O') {
                dfs(0, j, board, row, col);
            }
            if (board[row - 1][j] == 'O') {
                dfs(row - 1, j, board, row, col);
            }
        }
        for (int i = 0; i < row; i++) {
            if (board[i][0] == 'O') {
                dfs(i, 0, board, row, col);
            }
            if (board[i][col - 1] == 'O') {
                dfs(i, col - 1, board, row, col);
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if (board[i][j] == 'B') {
                    board[i][j] = 'O';
                }
            }
        }
    }
    private void dfs(int i, int j, char[][] board, int row, int col) {
        board[i][j] = 'B';
        for (int[] dir : dirs) {
            int tempI = dir[0] + i;
            int tempJ = dir[1] + j;
            if (tempI < 0 || tempI >= row || tempJ < 0 || tempJ >= col || board[tempI][tempJ] != 'O') {
                continue;
            }
            dfs(tempI, tempJ, board, row, col);
        }
    }
}
// @lc code=end

