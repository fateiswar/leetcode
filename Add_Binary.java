public class Solution {
    public String addBinary(String a, String b) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(a == null || a.length() == 0) return b;
        if(b == null || b.length() == 0) return a;
        a = new StringBuilder(a).reverse().toString();
        b = new StringBuilder(b).reverse().toString();
        int[] c = new int[Math.max(a.length(), b.length()) + 1];
        int carry = 0;
        int lena = a.length(), lenb = b.length();
        int pos = 0;
        for(pos = 0; carry > 0 || pos < lena || pos < lenb; pos++){
            if(pos < lena) carry += a.charAt(pos) - '0';
            if(pos < lenb) carry += b.charAt(pos) - '0';
            c[pos] = carry & 1;
            carry >>= 1;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = pos - 1; i >= 0; i--)
            sb.append(c[i]);
        return sb.toString();
    }
}
