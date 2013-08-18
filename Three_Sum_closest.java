public class Solution {
    public int threeSumClosest(int[] num, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        Arrays.sort(num);
        int answer = num[0] + num[1] + num[2];
        for(int i = 0; i < num.length; i++){
            int left = i + 1, right = num.length - 1;
            for(; left < right; ){
                int sum = num[i] + num[left] + num[right];
                if(sum == target)
                    return sum;
                if(Math.abs(answer - target) > Math.abs(sum - target)){
                    answer = sum;
                }
                if(sum < target) left++;
                else right--;
            }
        }
        return answer;
    }
}
