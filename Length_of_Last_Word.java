public class Solution {
    public int lengthOfLastWord(String ss) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(ss == null) return 0;
        char[] s = ss.toCharArray();
        int i = s.length - 1;
        for(; i >= 0 && s[i] == ' '; i--);
        if(i < 0) return 0;
        int len = 0;
        for(; i >= 0 && s[i] != ' '; i--)
            len++;
        return len;
    }
}
