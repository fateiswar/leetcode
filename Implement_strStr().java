public class Solution {
    public String strStr(String haystack, String needle) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(haystack == null) return null;
        if(needle == null) return haystack;
        if(haystack.length() == 0 && needle.length() == 0) return "";
        for(int i = 0; i < haystack.length(); i++){
            boolean ok = true;
            for(int j = 0; j < needle.length(); j++)
                if(i + j >= haystack.length() || haystack.charAt(i + j) != needle.charAt(j)){
                    ok = false;
                    break;
                }
            if(ok) return haystack.substring(i);
        }
        return null;
    }
}
