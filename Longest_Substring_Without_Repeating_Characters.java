public class Solution {
    public int lengthOfLongestSubstring(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(s == null || s.length() == 0) return 0;
        char[] c = s.toCharArray();
        int[] num = new int[256];
        int l = -1, answer = 0;
        for(int r = 0; r < c.length; r++){
            while(num[c[r]] > 0)
                num[c[++l]]--;
            num[c[r]]++;
            answer = Math.max(answer, r - l);
        }
        return answer;
    }
}
