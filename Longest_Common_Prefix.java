public class Solution {
    public String longestCommonPrefix(String[] strs) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(strs == null || strs.length == 0) return "";
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < strs[0].length(); i++){
            boolean flag = true;
            for(int j = 1; flag && j < strs.length; j++)
                if(i >= strs[j].length() || strs[j].charAt(i) != strs[0].charAt(i))
                    flag = false;
            if(flag) sb.append(strs[0].charAt(i));
            else break;
        }
        return sb.toString();
    }
}
