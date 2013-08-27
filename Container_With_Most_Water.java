public class Solution {
    int lower_bound(int[] height, ArrayList<Integer> list, int t){
        int low = 0, high = list.size() - 1;
        while(low != high){
            int mid = low + (high - low) / 2;
            int tmp = list.get(mid);
            if(height[tmp] >= t)
                high = mid;
            else
                low = mid + 1;
        }
        return low;
    }
    public int maxArea(int[] height) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<Integer> L = new ArrayList<Integer>(), R = new ArrayList<Integer>();
        int max = 0; 
        if(height == null || height.length < 2) return 0;
        for(int i = 0; i < height.length; i++)
            max = Math.max(max, height[i]);
        for(int i = 0; i < height.length; i++){
            if(L.size() == 0 || height[i] > height[L.get(L.size() - 1)]) L.add(i);
            if(height[i] == max) break;
        }
        for(int i = height.length - 1; i >= 0; i--){
            if(R.size() == 0 || height[i] > height[R.get(R.size() - 1)]) R.add(i);
            if(height[i] == max) break;
        }
        int answer = 0;
        for(int i = 0; i < L.size(); i++){
            int c = lower_bound(height, R, height[L.get(i)]);
            answer = Math.max(answer, Math.min(height[R.get(c)], height[L.get(i)]) * (R.get(c) - L.get(i)));
            c--;
            if(c >= 0)
                answer = Math.max(answer, Math.min(height[R.get(c)], height[L.get(i)]) * (R.get(c) - L.get(i)));
        }
        for(int i = 0; i < R.size(); i++){
            int c = lower_bound(height, L, height[R.get(i)]);
            answer = Math.max(answer, Math.min(height[R.get(i)], height[L.get(c)]) * (R.get(i) - L.get(c)));
            c--;
            if(c >= 0)
                answer = Math.max(answer, Math.min(height[R.get(i)], height[L.get(c)]) * (R.get(i) - L.get(c)));
        }
        return answer;
    }
}
