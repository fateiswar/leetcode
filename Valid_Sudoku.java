public class Solution {
    public boolean isValidSudoku(char[][] board) {
        // Start typing your Java solution below
        // DO NOT write main() function
        boolean[][] row = new boolean[9][10];
        boolean[][] col = new boolean[9][10];
        boolean[][] grid = new boolean[9][10];
        for(int i = 0; i < 9; i++)
            for(int j = 0; j < 9; j++) if(board[i][j] != '.'){
                if(row[i][board[i][j] - '0']) return false;
                row[i][board[i][j] - '0'] = true;
                if(col[j][board[i][j] - '0']) return false;
                col[j][board[i][j] - '0'] = true;
                if(grid[i / 3 * 3 + j / 3][board[i][j] - '0']) return false;
                grid[i / 3 * 3 + j / 3][board[i][j] - '0'] = true;
            }
        return true;
    }
}
