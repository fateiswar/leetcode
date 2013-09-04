public class Solution {
    boolean[] col, used1, used2;
    boolean valid(int r, int c, int n){
        return !col[c] && !used1[r + c] && !used2[n - 1 - r + c];
    }
    int dfs(int row, int n){
        if(row == n) return 1;
        int answer = 0;
        for(int c = 0; c < n; c++)
            if(valid(row, c, n)){
                col[c] = used1[row + c] = used2[n - 1 - row + c] = true;
                answer += dfs(row + 1, n);
                col[c] = used1[row + c] = used2[n - 1 - row + c] = false;
            }
        return answer;
    }
    public int totalNQueens(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(n <= 1) return n;
        col = new boolean[n];
        used1 = new boolean[n + n];
        used2 = new boolean[n + n];
        return dfs(0, n);
    }
}
