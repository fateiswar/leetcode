public class Solution {
    int numberOfOnes(int n){
        int result = 0;
        while(n > 0){
            result++;
            n = (n - 1) & n;
        }
        return result;
    }
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> answer = new ArrayList<ArrayList<Integer>>();
        if( k == 0 || n == 0) return answer;
        int max = (1 << n);
        for(int i = 0; i < max; i++)
            if(numberOfOnes(i) == k){
                ArrayList<Integer> sub = new ArrayList<Integer>();
                for(int j = 0; j < n; j++) if(((1<<j)&i) > 0){
                    sub.add(j + 1);
                }
                answer.add(sub);
            }
        return answer;
    }
}
