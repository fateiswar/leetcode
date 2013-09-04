public class Solution {
    boolean[][] row, col, grid;
    boolean dfs(int pos, char[][] board){
        if(pos == 81) return true;
        int r = pos / 9;
        int c = pos % 9;
        if(board[r][c] != '.') return dfs(pos + 1, board);
        for(int i = 1; i <= 9; i++){
            if(!row[r][i] && !col[c][i] && !grid[r / 3 * 3 + c / 3][i]){
                row[r][i] = col[c][i] = true;
                grid[r / 3 * 3 + c / 3][i] = true;
                board[r][c] = (char)(i + '0');
                if(dfs(pos + 1, board)) return true;
                row[r][i] = col[c][i] = false;
                grid[r / 3 * 3 + c / 3][i] = false;
            }
        }
        board[r][c] = '.';
        return false;
    }
    public void solveSudoku(char[][] board) {
        // Start typing your Java solution below
        // DO NOT write main() function
        row = new boolean[9][10];
        col = new boolean[9][10];
        grid = new boolean[9][10];
        for(int i = 0; i < 9; i++)
            for(int j = 0; j < 9; j++)
                if(board[i][j] != '.'){
                    row[i][board[i][j] - '0'] = true;
                    col[j][board[i][j] - '0'] = true;
                    grid[i / 3 * 3 + j / 3][board[i][j] - '0'] = true;
                }
        dfs(0, board);
    }
}
