public class Solution {
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> answer = new ArrayList<ArrayList<Integer>>();
        Arrays.sort(num);
        for(int i = 0; i < num.length; i++){
            if(i > 0 && num[i] == num[i - 1]) continue;
            int left = i + 1, right = num.length - 1;
            for(; left < right;){
                if(left > i + 1 && num[left] == num[left - 1]){
                    left ++;
                    continue;
                }
                if(right < num.length - 1 && num[right] == num[right + 1]){
                    right --;
                    continue;
                }
                if(num[i] + num[left] + num[right] == 0){
                    ArrayList<Integer> sub = new ArrayList<Integer>();
                    sub.add(num[i]); sub.add(num[left]); sub.add(num[right]);
                    answer.add(sub);
                    left++;
                    right--;
                }else if(num[i] + num[left] + num[right] < 0){
                    left++;
                }else{
                    right--;
                }
            }
        }
        return answer;
    }
}


