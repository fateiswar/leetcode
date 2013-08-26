public class Solution {
    public int largestRectangleArea(int[] height) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(height == null || height.length == 0) return 0;
        int[] h = Arrays.copyOf(height, height.length + 1);
        h[h.length - 1] = 0;
        Stack<Integer> stk = new Stack<Integer>();
        int answer = 0;
        for(int i = 0; i < h.length; i++){
            if(stk.empty() || h[i] > h[stk.peek()])
                stk.push(i);
            else{
                int tmp = stk.pop();
                answer = Math.max(answer, h[tmp] * (stk.empty() ? i : i - 1 - stk.peek()));
                i--;
            }
        }
        return answer;
    }
}
