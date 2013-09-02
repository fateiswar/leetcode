public class Solution {
    String s1, s2;
    boolean[][][] sol, cal;
    public boolean isScramble(String s1, String s2) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(s1 == null || s2 == null) return false;
        if(s1.length() != s2.length()) return false;
        this.s1 = s1;
        this.s2 = s2;
        int len = s1.length();
        sol = new boolean[len + 3][len + 3][len + 3];
        cal = new boolean[len + 3][len + 3][len + 3];
        return isScramble(0, 0, s1.length());
    }
    boolean isScramble(int start1, int start2, int len){
        if(cal[start1][start2][len]) return sol[start1][start2][len];
        cal[start1][start2][len] = true;
        if(len == 1) return sol[start1][start2][len] = (s1.charAt(start1) == s2.charAt(start2));
        char[] c1 = s1.substring(start1, start1 + len).toCharArray();
        char[] c2 = s2.substring(start2, start2 + len).toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        if(!(new String(c1)).equals(new String(c2)))
            return sol[start1][start2][len] = false;
        for(int i = start1; i < start1 + len - 1; i++){
            if(isScramble(start1, start2, i - start1 + 1) && isScramble(i + 1, i + 1 - start1 + start2, start1 +len - i - 1))
                return sol[start1][start2][len] = true;
            if(isScramble(i + 1, start2, start1 + len - i - 1) &&
                isScramble(start1, start2 + start1 + len - i - 1, i + 1 - start1))
                return sol[start1][start2][len] = true;
        }
        return sol[start1][start2][len] = false;
    }
}
