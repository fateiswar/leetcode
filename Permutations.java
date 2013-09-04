public class Solution {
    ArrayList<ArrayList<Integer>> answer;
    void dfs(int[] num, boolean[] used, ArrayList<Integer> sub){
        if(sub.size() == num.length){
            answer.add((ArrayList<Integer>)sub.clone());
            return;
        }
        for(int i = 0; i < num.length; i++) if(!used[i]){
            used[i] = true;
            sub.add(num[i]);
            dfs(num, used, sub);
            sub.remove(sub.size() - 1);
            used[i] = false;
        }
    }
    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        answer = new ArrayList<ArrayList<Integer>>();
        if(num == null || num.length == 0) return answer;
        ArrayList<Integer> sub = new ArrayList<Integer>();
        boolean[] used = new boolean[num.length];
        dfs(num, used, sub);
        return answer;
    }
}
