public class Solution {
    public ArrayList<Integer> grayCode(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<Integer> answer;
        if(n == 0){
            answer = new ArrayList<Integer>();
            answer.add(0);
            return answer;
        }
        if(n == 1){
            answer = new ArrayList<Integer>();
            answer.add(0);
            answer.add(1);
            return answer;
        }
        answer = grayCode(n - 1);
        int sz = answer.size();
        for(int i = sz - 1; i >= 0; i--)
            answer.add((1<<(n-1)) + answer.get(i));
        return answer;
    }
}
