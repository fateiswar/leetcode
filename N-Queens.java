public class Solution {
    boolean[] col, used1, used2;
    int[] conf;
    ArrayList<String[]> answer;
    void formSol(int n){
        String[] sub = new String[n];
        for(int r = 0; r < n; r++){
            StringBuilder sb = new StringBuilder();
            for(int c = 0; c < n; c++)
                if(conf[r] == c)
                    sb.append('Q');
                else
                    sb.append('.');
            sub[r] = sb.toString();
        }
        answer.add(sub);
    }
    void dfs(int r, int n){
        if(r == n){
            formSol(n);
            return;
        }
        for(int c = 0; c < n; c++) if(!col[c] && !used1[r + c] && !used2[n - 1 - r + c]){
            conf[r] = c;
            col[c] = used1[r + c] = used2[n - 1 - r + c] = true;
            dfs(r + 1, n);
            col[c] = used1[r + c] = used2[n - 1 - r + c] = false;
        }
    }
    public ArrayList<String[]> solveNQueens(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        answer = new ArrayList<String[]>();
        if(n == 0) return answer;
        col = new boolean[n];
        used1 = new boolean[n + n];
        used2 = new boolean[n + n];
        conf = new int[n];
        dfs(0, n);
        return answer;
    }
}
