public class Solution {
    boolean search(int[] A, int target, int low, int high){
        if(low > high) return false;
        int mid = low + (high - low) / 2;
        if(A[mid] == target) return true;
        if(A[mid] == A[low])
            return search(A, target, low, mid - 1) || search(A, target, mid + 1, high);
        else if(A[low] < A[mid]){
            if(target >= A[low] && target <= A[mid])
                return search(A, target, low, mid - 1);
            else return search(A, target, mid + 1, high);
        }else if(target >= A[mid] && target <= A[high])
            return search(A, target, mid + 1, high);
        else
            return search(A, target, low, mid - 1);
    }
    public boolean search(int[] A, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(A == null || A.length == 0) return false;
        return search(A, target, 0, A.length - 1);
    }
}
