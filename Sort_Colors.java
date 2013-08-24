public class Solution {
    public void sortColors(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int[] nums = new int[3];
        for(int i = 0; i < A.length; i++) nums[A[i]]++;
        int pos = 0;
        for(int i = 0; i < 3; i++){
            for(int j = 1; j <= nums[i]; j++)
                A[pos++] = i;
        }
    }
}
