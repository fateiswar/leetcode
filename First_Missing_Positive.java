public class Solution {
    public int firstMissingPositive(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(A == null || A.length == 0) return 1;
        for(int i = 0; i < A.length; i++){
            if(A[i] != i + 1 && A[i] >= 1 && A[i] <= A.length){
                int pos = A[i] - 1;
                if(A[pos] == A[i]) continue;
                int tmp = A[pos];
                A[pos] = A[i];
                A[i] = tmp;
                if(pos > i) i--;
            }
        }
        for(int i = 0; i < A.length; i++)
            if(A[i] != i + 1)
                return i + 1;
        return A.length + 1;
    }
}
