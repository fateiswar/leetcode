public class Solution {
    ArrayList<String> answer;
    int[] tmp;
    void formSol(){
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= 4; i++)
        {
            if(i > 1) sb.append('.');
            sb.append(tmp[i]);
        }
        answer.add(sb.toString());
    }
    int dfs(char[] s, int pos, int k, int n){
        if(pos == s.length){
            if(k == 4 && n != -1){
                tmp[4] = n;
                formSol();
            }
            return 0;
        }
        if(k > 4) return 0;
        if(n == -1){
            return dfs(s, pos + 1, k, s[pos] - '0');
        }
        if(n == 0){
            tmp[k] = 0;
            return dfs(s, pos, k + 1, -1);
        }
        tmp[k] = n;
        dfs(s, pos, k + 1, -1);
        if(n * 10 + s[pos] - '0' <= 255)
            dfs(s, pos + 1, k, n * 10 + s[pos] - '0');
        return 0;
    }
    public ArrayList<String> restoreIpAddresses(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        answer = new ArrayList<String>();
        tmp = new int[5];
        if(s == null) return answer;
        dfs(s.toCharArray(), 0, 1, -1);
        return answer;
    }
}
