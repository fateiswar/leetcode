public class Solution {
    public int maxSubArray(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(A == null || A.length == 0) return 0;
        int answer = A[0], curMax = A[0];
        for(int i = 1; i < A.length; i++)
        {
            curMax = Math.max(A[i], A[i] + curMax);
            answer = Math.max(answer, curMax);
        }
        return answer;
    }
}
