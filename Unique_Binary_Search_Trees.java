public class Solution {
    int numTrees(int n, HashMap<Integer, Integer> mp){
        if(n == 0) return 1;
        if(n == 1) return 1;
        if(mp.containsKey(n)) return mp.get(n);
        int answer = 0;
        for(int i = 0; i + i <= n - 1; i++){
            answer += numTrees(i, mp) * numTrees(n - 1 - i,  mp);
            if(i + i != n - 1)
                answer += numTrees(i, mp) * numTrees(n - 1 - i, mp);
        }
        mp.put(n, answer);
        return answer;
    }
    public int numTrees(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        HashMap<Integer, Integer> mp = new HashMap<Integer, Integer>();
        return numTrees(n, mp);
    }
}
