public class Solution {
    public int searchInsert(int[] A, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(A == null || A.length == 0) return 0;
        if(A[A.length - 1] < target) return A.length;
        int low = 0, high = A.length - 1;
        while(low < high){
            int mid = low + (high - low) / 2;
            if(A[mid] >= target)
                high = mid;
            else
                low = mid + 1;
        }
        return low;
    }
}
