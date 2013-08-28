public class Solution {
    public boolean isMatch(String ss, String pp) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(ss == null || pp == null) return false;
        char[] s = ss.toCharArray(), p = pp.toCharArray();
        int i = 0, j = 0, star = -1, checkpoint = 0;
        for(i = 0; i < s.length; ){
            if(j < p.length && p[j] == '*'){
                star = j++;
                checkpoint = i;
                continue;
            }
            if(j < p.length && (p[j] == '?' || p[j] == s[i])){
                i++;
                j++;
                continue;
            }
            if(star == -1) return false;
            i = ++checkpoint;
            j = star + 1;
        }
        while(j < p.length && p[j] == '*') j++;
        return j == p.length;
    }
}
