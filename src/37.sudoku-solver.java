/*
 * @lc app=leetcode id=37 lang=java
 *
 * [37] Sudoku Solver
 *
 * https://leetcode.com/problems/sudoku-solver/description/
 *
 * algorithms
 * Hard (41.77%)
 * Likes:    1520
 * Dislikes: 87
 * Total Accepted:    173.1K
 * Total Submissions: 414.4K
 * Testcase Example:  '[["5","3",".",".","7",".",".",".","."],["6",".",".","1","9","5",".",".","."],[".","9","8",".",".",".",".","6","."],["8",".",".",".","6",".",".",".","3"],["4",".",".","8",".","3",".",".","1"],["7",".",".",".","2",".",".",".","6"],[".","6",".",".",".",".","2","8","."],[".",".",".","4","1","9",".",".","5"],[".",".",".",".","8",".",".","7","9"]]'
 *
 * Write a program to solve a Sudoku puzzle by filling the empty cells.
 * 
 * A sudoku solution must satisfy all of the following rules:
 * 
 * 
 * Each of the digits 1-9 must occur exactly once in each row.
 * Each of the digits 1-9 must occur exactly once in each column.
 * Each of the the digits 1-9 must occur exactly once in each of the 9 3x3
 * sub-boxes of the grid.
 * 
 * 
 * Empty cells are indicated by the character '.'.
 * 
 * 
 * A sudoku puzzle...
 * 
 * 
 * ...and its solution numbers marked in red.
 * 
 * Note:
 * 
 * 
 * The given board contain only digits 1-9 and the character '.'.
 * You may assume that the given Sudoku puzzle will have a single unique
 * solution.
 * The given board size is always 9x9.
 * 
 * 
 */

// @lc code=start
class Solution {
    public void solveSudoku(char[][] board) {
        if (board == null || board.length != 9 || board[0].length != 9) {
            return;
        }
        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] boxs = new boolean[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                int k = i / 3 * 3 + j / 3;
                int num = board[i][j] - '1';
                rows[i][num] = true;
                cols[j][num] = true;
                boxs[k][num] = true;
            }
        }
        backtrack(board, 0, rows, cols, boxs);
    }
    private boolean backtrack(char[][] board, int n, boolean[][] rows, boolean[][] cols, boolean[][] boxs) {
        if (n == 81) {
            return true;
        }
        int i = n / 9, j = n % 9;
        if (board[i][j] != '.') {
            return backtrack(board, n + 1, rows, cols, boxs);
        }
        int k = i / 3 * 3 + j / 3;
        for (int num = 0; num < 9; num++) {
            if (rows[i][num] || cols[j][num] || boxs[k][num]) {
                continue;
            }
            board[i][j] = (char)(num + '1');
            rows[i][num] = cols[j][num] = boxs[k][num] = true;
            if (backtrack(board, n + 1, rows, cols, boxs)) {
                return true;
            }
            rows[i][num] = cols[j][num] = boxs[k][num] = false;
        }
        board[i][j] = '.';
        return false;
    }
}
// @lc code=end

