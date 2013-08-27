public class Solution {
    public int maxArea(int[] height) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(height == null || height.length < 2) return 0;
        int answer = 0;
        for(int left = 0, right = height.length - 1; left < right; ){
            answer = Math.max(answer, Math.min(height[left], height[right]) * (right - left));
            if(height[left] < height[right])
                left++;
            else
                right--;
        }
        return answer;
    }
}
