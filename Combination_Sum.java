public class Solution {
    ArrayList<ArrayList<Integer>> answer;
    void formSol(int[] A, ArrayList<Integer> path){
        ArrayList<Integer> sub = new ArrayList<Integer>();
        for(int i = 0; i < path.size(); i++)
            for(int j = 1; j <= path.get(i); j++)
                sub.add(A[i]);
        answer.add(sub);
    }
    void dfs(int[] A, int len, int remain, ArrayList<Integer> path){
        if(remain == 0){
            formSol(A, path);
            return;
        }
        if(path.size() == len) return;
        if(A[path.size()] > remain) return;
        int pos = path.size();
        for(int i = 0; A[pos] * i <= remain; i++)
        {
            path.add(i);
            dfs(A, len, remain - A[pos] * i, path);
            path.remove(pos);
        }
    } 
    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        answer = new ArrayList<ArrayList<Integer>>();
        if(candidates == null || candidates.length == 0) return answer;
        Arrays.sort(candidates);
        int len = 0;
        for(int i = 0; i < candidates.length; i++){
            if(len == 0 || candidates[i] != candidates[len - 1])
                candidates[len++] = candidates[i];
        }
        dfs(candidates, len, target, new ArrayList<Integer>());
        return answer;
    }
}
