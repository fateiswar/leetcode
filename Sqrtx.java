public class Solution {
    public int sqrt(int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(x == 0) return 0;
        int low = 1, high = x;
        while(low < high){
            int mid = low + (high - low + 1) / 2;
            if((long)mid * mid > x)
                high = mid - 1;
            else low = mid;
        }
        return low;
    }
}
