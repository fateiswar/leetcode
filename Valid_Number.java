public class Solution {
    public boolean isNumber(String ss) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(ss == null) return false;
        char[] s = ss.trim().toCharArray();
        if(s.length == 0) return false;
        int pos = 0;
        if(s[pos] == '+' || s[pos] == '-') pos++;
        if(pos == s.length) return false;
        boolean hasNumber = false;
        int leading = 0;
        boolean isDot = false, isExp = false;
        for(; pos < s.length; pos++){
            if(s[pos] == '0'){
                //if(!isDot && leading >= 1) return false;
                if(leading >= 0) leading++;
            }else if(s[pos] == 'e' || s[pos] == 'E'){
                if(isExp) return false;
                if(leading == 0) return false;
                isExp = true;
                leading = 0;
            }else if(s[pos] == '.'){
                if(isExp || isDot) return false;
                isDot = true;
            }else if(s[pos] > '0' && s[pos] <= '9'){
                leading = -1;
            }else if(s[pos] == '+' || s[pos] == '-'){
                if(s[pos - 1] != 'E' && s[pos - 1] != 'e') return false;
            }else return false;
        }
        if(leading == 0) return false;
        return true;
    }
}
