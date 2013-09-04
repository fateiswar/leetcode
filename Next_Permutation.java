public class Solution {
    void reverse(int[] num, int start, int end){
        for(int i = start, j = end; i < j; i++, j--){
            int tmp = num[i];
            num[i] = num[j];
            num[j] = tmp;
        }
    }
    public void nextPermutation(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(num == null || num.length <= 1) return;
        int i = 0;
        for(i = num.length - 2; i >= 0 && num[i] > num[i + 1]; i--);
        if( i < 0){
            reverse(num, 0, num.length - 1);
            return;
        }
        reverse(num, i + 1, num.length - 1);
        for(int j = i + 1; j < num.length; j++)
            if(num[i] < num[j]){
                int tmp = num[i];
                num[i] = num[j];
                num[j] = tmp;
                break;
            }
    }
}
