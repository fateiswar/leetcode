public class Solution {
    int kth(int[] A, int startA, int[] B, int startB, int k){
        if(startA == A.length) return B[startB + k - 1];
        if(startB == B.length) return A[startA + k - 1];
        if(k == 1) return Math.min(A[startA], B[startB]);
        if(A.length - startA > B.length - startB)
            return kth(B, startB, A, startA, k);
        int m = Math.min(k / 2, A.length - startA);
        if(A[startA + m - 1] < B[startB + m -1])
            return kth(A, startA + m, B, startB, k - m);
        return kth(A, startA, B, startB + m, k - m);
    }
    public double findMedianSortedArrays(int A[], int B[]) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int size = A.length + B.length;
        if(size % 2 == 1){
            return kth(A, 0, B, 0, size / 2 + 1);
        }else
            return (kth(A, 0, B, 0, size / 2) + kth(A, 0, B, 0, size / 2 + 1)) / 2.0;
    }
}
