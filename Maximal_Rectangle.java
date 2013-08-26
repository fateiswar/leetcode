public class Solution {
    public int LargestRectangle(int[] h){
        Stack<Integer> stk = new Stack<Integer>();
        int answer = 0;
        for(int i = 0; i < h.length; i++)
            if(stk.empty() || h[stk.peek()] < h[i])
                stk.push(i);
            else{
                int tmp = h[stk.pop()];
                answer = Math.max(answer, tmp * (stk.empty() ? i : i - 1 - stk.peek()));
                i--;
            }
        return answer;
    }
    
    public int maximalRectangle(char[][] matrix) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int m = matrix.length, n = matrix[0].length;
        int[] height = new int[n + 1];
        int answer = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0;j < n; j++)
                height[j] = (matrix[i][j] == '1' ? 1 + height[j] : 0);
            answer = Math.max(answer, LargestRectangle(height));
        }
        return answer;
    }
}
