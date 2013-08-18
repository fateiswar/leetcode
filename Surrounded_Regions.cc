class Solution {
public:
    int dir[4][2] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    
    void floodfill(vector<vector<char> >& board, vector<vector<bool> >& visit, int x, int y){
        visit[x][y] = true;
        queue<int> Q;
        Q.push(x);
        Q.push(y);
        int m = board.size(), n = board[0].size();
        while(!Q.empty()){
            int cx = Q.front(); Q.pop();
            int cy = Q.front(); Q.pop();
            for(int i = 0; i < 4; i++){
                int nx = cx + dir[i][0], ny = cy + dir[i][1];
                if(nx < 0 || nx >= m || ny < 0 || ny >= n || board[nx][ny] != 'O' || visit[nx][ny])
                    continue;
                visit[nx][ny] = true;
                Q.push(nx); Q.push(ny);
            }
        }
    }
    void solve(vector<vector<char>> &board) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        int m = board.size(); if(m == 0) return;
        int n = board[0].size(); if(n == 0) return;
        vector<vector<bool> > visit(m + 3, vector<bool>(n+3, false));
        for(int i = 0; i < m ;i++){
            if(board[i][0] == 'O' && !visit[i][0]) floodfill(board, visit, i, 0);
            if(board[i][n - 1] == 'O' && !visit[i][n - 1]) floodfill(board, visit, i, n - 1);
        }
        for(int j = 0; j < n; j++){
            if(board[0][j] == 'O' && !visit[0][j]) floodfill(board, visit, 0, j);
            if(board[m - 1][j] == 'O' && !visit[m - 1][j]) floodfill(board, visit, m - 1, j);
        }
        for(int i = 0; i < m; i++)
            for(int j = 0; j < n ;j++)
                if(!visit[i][j])
                    board[i][j] = 'X';
    }
};
