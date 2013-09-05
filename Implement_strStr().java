public class Solution {
    public String strStr(String haystack, String needle) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(haystack == null) return null;
        if(needle == null) return haystack;
        if(haystack.length() == 0 && needle.length() == 0) return "";
        if(haystack.length() < needle.length()) return null;
        long mod = (1<<31) - 1, a = 0, b = 0, c = 1;
        for(int i = 0; i < needle.length(); i++){
            if(i != 0) c = (c << 8) & mod;
            a = ((a << 8) + haystack.charAt(i)) & mod;
            b = ((b << 8) + needle.charAt(i)) & mod;
        }
        for(int i = 0; i + needle.length() <= haystack.length(); i++){
            if(i != 0){
                a = (a + mod + 1 - ((haystack.charAt(i - 1) * c) & mod)) & mod;
                a = ((a << 8) + haystack.charAt(i + needle.length() - 1)) & mod;
            }
            if(a != b) continue;
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
