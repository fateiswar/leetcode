public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        HashMap<Integer, Integer> mp = new HashMap<Integer, Integer>();
        for(int i = 0; i < numbers.length; i++)
            mp.put(numbers[i], i);
        int[] answer = new int[2];
        for(int i = 0; i < numbers.length; i++)
            if(mp.get(target - numbers[i]) != null && mp.get(target - numbers[i]) != i){
                answer[0] = i + 1;
                answer[1] = mp.get(target - numbers[i]) + 1;
                break;
            }
        return answer;
    }
}
