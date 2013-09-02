public class Solution {
    public int removeDuplicates(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(A == null || A.length == 0) return 0;
        int len = 0;
        for(int i = 0; i < A.length; i++){
            if(len > 1 && A[i] == A[len - 1] && A[i] == A[len - 2]){
                continue;
            }
            A[len++] = A[i];
        }
        return len;
    }
}
