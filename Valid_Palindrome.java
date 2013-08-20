public class Solution {
    boolean isAlpha(char c){
        return c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z' || c >= '0' && c <= '9';
    }
    public boolean isPalindrome(String ss) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(ss == null || ss.length() < 2) return true;
        ss = ss.toLowerCase();
        char[] s = ss.toCharArray();
        for(int i = 0, j = s.length - 1; i < j; ){
            if(!isAlpha(s[i])){
                i++;
            }else if(!isAlpha(s[j])){
                j--;
            }else if(s[i] != s[j])
                return false;
            else{
                i++;
                j--;
            }
        }
        return true;
    }
}
