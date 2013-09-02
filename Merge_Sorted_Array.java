public class Solution {
    public void merge(int A[], int m, int B[], int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int top = m + n - 1;
        for(int i = m - 1, j = n - 1; j >= 0;){
            if(i < 0){
                while(j >= 0){
                    A[top--] = B[j--];
                }
            }else if(A[i] > B[j])
                A[top--] = A[i--];
            else
                A[top--] = B[j--];
        }
    }
}
