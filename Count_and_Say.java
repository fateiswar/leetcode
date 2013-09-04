public class Solution {
    String next(String curr){
        StringBuilder sb = new StringBuilder();
        char[] cur = curr.toCharArray();
        for(int i = 0, j = 0; i < cur.length; i = j){
            int n = 0;
            for(j = i; j < cur.length && cur[j] == cur[i]; j++)
                n++;
            sb.append(n);
            sb.append(cur[i]);
        }
        return sb.toString();
    }
    public String countAndSay(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        String init = "1";
        if(n == 1) return init;
        for(int i = 1; i < n; i++){
            init = next(init);
        }
        return init;
    }
}
