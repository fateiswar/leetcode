public class Solution {
    public boolean isValid(String ss) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(ss == null) return true;
        char[] match = new char[256];
        match['('] = ')';
        match[')'] = '(';
        match['{'] = '}';
        match['}'] = '{';
        match['['] = ']';
        match[']'] = '[';
        Stack<Character> stk = new Stack<Character>();
        char[] s = ss.toCharArray();
        for(int i = 0; i < s.length; i++)
            if(s[i] == '(' || s[i] == '[' || s[i] == '{')
                stk.push(s[i]);
            else{
                if(stk.empty() || stk.peek() != match[s[i]])
                    return false;
                stk.pop();
            }
        return stk.empty();
    }
}
