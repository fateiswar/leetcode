public class Solution {
    public int jump(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(A == null || A.length == 0) return 0;
        int step = 0;
        int pos = 0, maxPos = 0;
        while(maxPos < A.length - 1){
            int max = maxPos;
            for(int i = pos; i <= maxPos; i++)
                max = Math.max(max, i + A[i]);
            if(max > maxPos){
                step++;
                pos = maxPos + 1;
                maxPos = max;
            }else return -1;
        }
        return step;
    }
}
