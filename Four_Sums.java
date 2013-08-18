public class Solution {
    public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> answer = new ArrayList<ArrayList<Integer>>(128);
        if(num == null || num.length < 4) return answer;
        Arrays.sort(num);
        for(int i = 0; i < num.length; i++){
            if(i > 0 && num[i] == num[i - 1]) continue;
            for(int j = i + 1; j < num.length; j++){
                if(j > i + 1 && num[j] == num[j - 1]) continue;
                int left = j + 1, right = num.length - 1;
                for(; left < right; ){
                    if(left > j + 1 && num[left] == num[left - 1]) { left++; continue; }
                    if(right < num.length - 1 && num[right] == num[right + 1]) {right--; continue; }
                    int sum = num[i] + num[j] + num[left] + num[right];
                    if(sum == target){
                        ArrayList<Integer> sub = new ArrayList<Integer>(4);
                        sub.add(num[i]); sub.add(num[j]);
                        sub.add(num[left]); sub.add(num[right]);
                        answer.add(sub);
                        left++;
                        right--;
                    }else if(sum < target)
                        left++;
                    else right--;
                }
            }
        }
        return answer;
    }
}


