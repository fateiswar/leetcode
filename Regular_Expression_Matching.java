public class Solution {
    boolean isMatch(char[] s, char[] p, int i , int j){
        if(i == s.length){
            if(j + 1 < p.length && p[j + 1] == '*')
                return isMatch(s, p, i, j + 2);
            return j == p.length;
        }
        if(j == p.length) return false;
        if(j + 1 < p.length && p[j + 1] == '*'){
            if(isMatch(s, p, i + 1, j + 2)) return true;
            for(int k = 0; (i + k < s.length) && (s[i + k] == p[j] || p[j] == '.'); k++){
                if(isMatch(s, p, i + k + 1, j + 2))
                    return true;
            }
            return false;
        }else
            return (s[i] == p[j] || p[j] == '.') && isMatch(i + 1, j + 1);
    }
    public boolean isMatch(String s, String p) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (s == null || p == null) return false;
        return isMatch(s.toCharArray(), p.toCharArray(), 0, 0);
    }
}
