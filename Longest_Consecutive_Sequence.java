public class Solution {
    public int solve(int n, HashMap<Integer, Boolean> mp){
        int answer = 1;
        mp.put(n, true);
        for(int i = n + 1; mp.get(i) != null; i++)
        {
            mp.put(i, true);
            answer++;
        }
        for(int i = n - 1; mp.get(i) != null; i--){
            mp.put(i, true);
            answer++;
        }
        return answer;
    }
    public int longestConsecutive(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(num == null || num.length == 0) return 0;
        HashMap<Integer, Boolean> mp = new HashMap<Integer, Boolean>();
        for(int i = 0; i < num.length; i++) mp.put(num[i], false);
        int answer = 0;
        for(int i = 0; i < num.length; i++) if(mp.get(num[i]) == false)
        {
            int tmp = solve(num[i], mp);
            answer = Math.max(answer, tmp);
        }
        return answer;
    }
}


