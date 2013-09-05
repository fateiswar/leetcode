public class Solution {
    public int romanToInt(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(s == null || s.length() == 0) return 0;
        int[] mp = new int[256];
        mp['I'] = 1;
        mp['V'] = 5;
        mp['X'] = 10;
        mp['L'] = 50;
        mp['C'] = 100;
        mp['D'] = 500;
        mp['M'] = 1000;
        int answer = 0;
        char[] c = s.toCharArray();
        for(int i = 0; i < c.length; i++)
        {
            answer += mp[c[i]];
            if(i > 0 && mp[c[i - 1]] < mp[c[i]])
                answer -= 2 * mp[c[i - 1]];
        }
        return answer;
    }
}
