public class Solution {
    int[] f;
    boolean[] used;
    void dfs(int remain, int n, int k, StringBuilder sb){
        if(remain == 0) return;
        for(int i = 1; i <= n; i++) if(!used[i]){
            if(f[remain - 1] >= k){
                used[i] = true;
                sb.append(i);
                dfs(remain - 1, n, k, sb);
                return;
            }
            k -= f[remain - 1];
        }
    }
    public String getPermutation(int n, int k) {
        // Start typing your Java solution below
        // DO NOT write main() function
        f = new int[n + 1];
        f[0] = 1;
        for(int i = 1; i <= n; i++) f[i] = i * f[i - 1];
        StringBuilder sb = new StringBuilder();
        used = new boolean[n + 1];
        dfs(n, n, k, sb);
        return sb.toString();
    }
}
