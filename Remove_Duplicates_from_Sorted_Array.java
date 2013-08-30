public class Solution {
    public int removeDuplicates(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(A == null) return 0;
        int last = -1;
        for(int i = 0; i < A.length; i++)
            if(last == -1 || A[i] != A[last])
                A[++last] = A[i];
        return last + 1;
    }
}
