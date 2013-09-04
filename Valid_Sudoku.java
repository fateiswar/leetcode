public class Solution {
    public boolean isValidSudoku(char[][] board) {
        // Start typing your Java solution below
        // DO NOT write main() function
        boolean[][] row = new boolean[9][10];
        boolean[][] col = new boolean[9][10];
        boolean[][] grid = new boolean[9][10];
        for(int i = 0; i < 9; i++)
            for(int j = 0; j < 9; j++){
                if(row[i][board[j]) return false;
                row[i][board[j]] = true;
                if(col[j][board[j]) return false;
                col[j][board[j]] = true;
                if(grid[i / 3 * 3 + j / 3][board[j]]) return false;
                grid[i / 3 * 3 + j / 3][board[j]] = true;
            }
        return true;
    }
}
