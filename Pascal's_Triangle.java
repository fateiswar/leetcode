public class Solution {
    public ArrayList<ArrayList<Integer>> generate(int numRows) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> answer = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i < numRows; i++){
            answer.add(new ArrayList<Integer>());
            answer.get(i).add(1);
            for(int j = 1; j < i; j++)
                answer.get(i).add(answer.get(i - 1).get(j - 1) + answer.get(i - 1).get(j));
            if(i != 0) answer.get(i).add(1);
        }
        return answer;
    }
}
