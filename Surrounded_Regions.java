import java.util.*;
//TLE
public class SurroundedRegions {
    boolean[][] flag;
    int[][] dir;
    LinkedList<Integer> Q;
    public SurroundedRegions(){
        dir = new int[][]{ {0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    }
    void floodfill(char[][] board, int x, int y){
        Q.offer(x); Q.offer(y);
        flag[x][y] = true;
        int m = board.length, n = board[0].length;
        while(Q.size() != 0){
            x = Q.poll();
            y = Q.poll();
            for(int i = 0; i < 4; i++){
                int nx = x + dir[i][0];
                int ny = y + dir[i][1];
                if(nx < 0 || nx >= m || ny < 0 || ny >= n || flag[nx][ny] == true || board[nx][ny] != 'O') continue;
                flag[nx][ny] = true;
                Q.offer(nx);
                Q.offer(ny);
            }
        }
    }
    public void solve(char[][] board) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int m  = board.length;
        if(m == 0) return ;
        int n = board[0].length;
        if(n == 0) return;
        flag = new boolean[m][n];
        Q = new LinkedList<Integer>();
        for(int i = 0; i < m; i++){
            if(board[i][0] == 'O' && !flag[i][0]) floodfill(board, i, 0);
            if(board[i][n - 1] == 'O' && !flag[i][n - 1]) floodfill(board, i, n - 1);
        }
        for(int j = 0; j < n; j++){
            if(board[0][j] == 'O' && !flag[0][j]) floodfill(board, 0, j);
            if(board[m - 1][j] == 'O' && !flag[m - 1][j]) floodfill(board, m - 1, j);
        }
        for(int i = 0; i < m; i++) 
            for(int j = 0; j < n; j++)
                if(!flag[i][j])
                    board[i][j] = 'X';
        return;
    }
}













