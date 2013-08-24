public class Solution {
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> answer = new ArrayList<ArrayList<Integer>>();
        answer.add(new ArrayList<Integer>());
        if(S == null || S.length == 0) return answer;
        Arrays.sort(S);
        int max = 1;
        for(int i = 1; i <= S.length; i++) max <<= 1;
        for(int i = 1; i < max; i++){
            ArrayList<Integer> sub = new ArrayList<Integer>();
            for(int j = 0; j < S.length; j++)
                if(((1<<j) & i) != 0)
                    sub.add(S[j]);
            answer.add(sub);
        }
        return answer;
    }
}
