public class Solution {
    ArrayList<ArrayList<Integer>> answer;
    void dfs(int[] num, boolean[] used, ArrayList<Integer> sub){
        if(sub.size() == num.length){
            answer.add((ArrayList<Integer>)sub.clone());
            return;
        }
        for(int i = 0; i < num.length; i++) if(!used[i]){
            if(i > 0 && num[i] == num[i - 1] && !used[i - 1]) continue;
            used[i] = true;
            sub.add(num[i]);
            dfs(num, used, sub);
            sub.remove(sub.size() - 1);
            used[i] = false;
        }
    }
    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        answer = new ArrayList<ArrayList<Integer>>();
        if(num == null || num.length == 0) return answer;
        Arrays.sort(num);
        boolean[] used = new boolean[num.length];
        ArrayList<Integer> sub = new ArrayList<Integer>();
        dfs(num, used, sub);
        return answer;
    }
}
