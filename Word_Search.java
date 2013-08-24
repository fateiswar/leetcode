public class Solution {
    public boolean exist(char[][] board, boolean[][] visit, char[] word,  int pos, int x, int y){
        int m = board.length, n = board[0].length;
        if(pos == word.length) return true;
        if(pos == 0){
            for(int i = 0; i < m; i++)
                for(int j = 0; j < n; j++) if(board[i][j] == word[0])
                {
                    visit[i][j] = true;
                    if(exist(board, visit, word, 1, i, j)) return true;
                    visit[i][j] = false;
                }
            return false;
        }
        int[][] dir = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for(int i = 0; i < 4; i++){
            int nx = x + dir[i][0], ny = y + dir[i][1];
            if(nx < 0 || nx >= m || ny < 0 || ny >= n || visit[nx][ny] || board[nx][ny] != word[pos])
                continue;
            visit[nx][ny] = true;
            if(exist(board, visit, word, pos + 1, nx, ny)) return true;
            visit[nx][ny] = false;
        }
        return false;
    }
    public boolean exist(char[][] board, String word) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(board.length == 0) return false;
        if(board[0].length == 0) return false;
        if(word == null || word.length() == 0) return true;
        boolean[][] visit = new boolean[board.length][board[0].length];
        return exist(board, visit, word.toCharArray(), 0, 0, 0);
    }
}
