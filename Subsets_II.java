public class Solution {
    ArrayList<Integer> l1, l2;
    int[] path;
    ArrayList<Integer> formSol(){
        ArrayList<Integer> sub = new ArrayList<Integer>();
        for(int i = 0; i < path.length; i++){
            for(int j = 1; j <= path[i]; j++)
                sub.add(l1.get(i));
        }
        return sub;
    }
    void dfs(int pos, ArrayList<ArrayList<Integer>> answer){
        if(pos == l1.size()){
            answer.add(formSol());
            return;
        }
        for(int i = 0; i <= l2.get(pos); i++){
            path[pos] = i;
            dfs(pos + 1, answer);
        }
    }
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> answer = new ArrayList<ArrayList<Integer>>();
        if(num == null || num.length == 0){
            answer.add(new ArrayList<Integer>());
            return answer;
        }
        Arrays.sort(num);
        l1 = new ArrayList<Integer>();
        l2 = new ArrayList<Integer>();
        l1.add(num[0]);
        l2.add(1);
        for(int i = 1; i < num.length; i++){
            if(num[i] == num[i - 1])
                l2.set(l2.size() - 1, l2.get(l2.size() - 1) + 1);
            else{
                l1.add(num[i]);
                l2.add(1);
            }
        }
        path = new int[l1.size()];
        dfs(0, answer);
        return answer;
    }
}
