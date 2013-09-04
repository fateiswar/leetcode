public class Solution {
    public int[] searchRange(int[] A, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int[] answer = new int[2];
        if(A == null || A.length == 0){
            answer[0] = answer[1] = -1;
            return answer;
        }
        if(A[A.length - 1] < target){
            answer[0] = answer[1] = -1;
            return answer;
        }
        int low = 0, high = A.length - 1;
        while(low != high){
            int mid = low + (high - low) / 2;
            if(A[mid] >= target)
                high = mid;
            else
                low = mid + 1;
        }
        if(A[low] != target){
            answer[0] = answer[1] = -1;
            return answer;
        }
        answer[0] = low;
        if(A[A.length - 1] == target){
            answer[1] = A.length - 1;
            return answer;
        }
        high = A.length - 1;
        while(low != high){
            int mid = low + (high - low) / 2;
            if(A[mid] > target)
                high = mid;
            else
                low = mid + 1;
        }
        answer[1] = low - 1;
        return answer;
    }
}
