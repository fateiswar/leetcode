public class Solution {
    public int trap(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (A == null || A.length <= 2) return 0;
        int[] L = new int[A.length], R = new int[A.length];
        for(int i = 1; i < A.length; i++)
            L[i] = Math.max(L[i - 1], A[i - 1]);
        for(int i = A.length - 2; i >= 0; i--)
            R[i] = Math.max(R[i + 1], A[i + 1]);
        int sum = 0;
        for(int i = 0;  i < A.length; i++)
            if(Math.min(L[i], R[i]) > A[i])
                sum += Math.min(L[i], R[i]) - A[i];
        return sum;
    }
}
