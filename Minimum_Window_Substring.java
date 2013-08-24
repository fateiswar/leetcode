public class Solution {
    public String minWindow(String SS, String TT) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(SS.equals("")) return "";
        char[] S = SS.toCharArray();
        char[] T = TT.toCharArray();
        int[] mp = new int[256];
        for(int i = 0; i < T.length; i++)
            mp[T[i]]++;
        int[] used = new int[256];
        if(T.length == 0)  return "";
        int min = -1;
        String answer = "";
        int left = 0, right = 0;
        int has = 0;
        for(; right < S.length; right++){
            if(++used[S[right]] == mp[S[right]]){
                has+= mp[S[right]];
            }
            while(left <= right && (used[S[left]] > mp[S[left]])) --used[S[left++]];
            if(has == T.length && (min == -1 || min > right - left + 1)){
                min = right - left + 1;
                answer = SS.substring(left, right + 1);
            }
        }
        return answer;
    }
}


