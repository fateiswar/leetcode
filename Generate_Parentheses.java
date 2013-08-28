public class Solution {
    char[] buf;
    ArrayList<String> answer;
    void dfs(int n, int l, int r){
        if(l == n && r == n){
            answer.add(new String(buf));
            return;
        }
        if(l < n){
            buf[l + r] = '(';
            dfs(n, l + 1, r);
        }
        if(r < l){
            buf[l + r] = ')';
            dfs(n, l, r + 1);
        }
    }
    public ArrayList<String> generateParenthesis(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        answer = new ArrayList<String>();
        if(n == 0){
            answer.add("");
            return answer;
        }
        buf = new char[n + n];
        dfs(n, 0, 0);
        return answer;
    }
}
