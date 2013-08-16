public class median_of_two_sorted_arrays {
    public int kth(int[] A, int starta, int[] B, int startb, int k){
        if(A.length == starta) return B[startb + k - 1];
        if(B.length == startb) return A[starta + k - 1];
        if(k == 1) return Math.min(A[starta], B[startb]);
        if(A.length - starta > B.length - startb)
            return kth(B, startb, A, starta, k);
        int m = k / 2;
        m = Math.min(m, A.length - starta);
        if(A[starta + m - 1] < B[startb + m - 1])
            return kth(A, starta + m, B, startb, k - m);
        else
            return kth(A, starta, B, startb + m, k - m);
    }
    public double findMedianSortedArrays(int A[], int B[]) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int l = A.length + B.length;
        if(l % 2 == 1)
            return kth(A, 0, B, 0, l / 2 + 1);
        else
            return (1.0 * kth(A, 0, B, 0, l / 2) + kth(A, 0, B, 0, l / 2 + 1)) / 2;
    }
}
