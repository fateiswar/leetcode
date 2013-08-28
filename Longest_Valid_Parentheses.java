public class Solution {
    public int longestValidParentheses(char[] s, char c){
        int left = 0, n = 0;
        int answer = 0;
        for(int i = 0; i < s.length; i++)
            if(s[i] == c)
                n++;
            else if(n == 0)
                left = i + 1;
            else{
                n--;
                if(n == 0)
                    answer = Math.max(answer, i - left + 1);
            }
        return answer;
                
    }
    public int longestValidParentheses(String ss) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(ss == null) return 0;
        char[] s = ss.toCharArray();
        int answer = longestValidParentheses(s, '(');
        s = new StringBuilder(ss).reverse().toString().toCharArray();
        int tmp = longestValidParentheses(s, ')');
        answer = Math.max(answer, tmp);
        return answer;
    }
}
