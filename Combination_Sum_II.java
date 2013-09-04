public class Solution {
    ArrayList<ArrayList<Integer>> answer;
    void formSol(int[] A, boolean[] used){
        ArrayList<Integer> sub = new ArrayList<Integer>();
        for(int i = 0; i < used.length; i++) if(used[i])
            sub.add(A[i]);
        answer.add(sub);
    }
    void dfs(int[] A, int len, int pos, int remain, boolean[] used){
        if(remain == 0){
            formSol(A, used);
            return;
        }
        if(pos == len) return;
        if(A[pos] > remain) return;
        used[pos] = false;
        dfs(A, len, pos + 1, remain, used);
        if(pos > 0 && A[pos] == A[pos - 1] && !used[pos - 1]) return;
        used[pos] = true;
        dfs(A, len, pos + 1, remain - A[pos], used);
        used[pos] = false;
    } 
    public ArrayList<ArrayList<Integer>> combinationSum2(int[] candidates, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        answer = new ArrayList<ArrayList<Integer>>();
        if(candidates == null || candidates.length == 0) return answer;
        Arrays.sort(candidates);
        boolean[] used = new boolean[candidates.length];
        dfs(candidates, candidates.length, 0, target, used);
        return answer;
    }
}
