public class Solution {
    public boolean canJump(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(A == null || A.length == 0) return true;
        int pos = 0, maxPos = 0;
        for(; pos <= maxPos && pos < A.length; pos++){
            maxPos = Math.max(maxPos, pos + A[pos]);
        }
        return maxPos >= A.length - 1;
    }
}
