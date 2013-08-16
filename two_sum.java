public class two_sum {
    public int[] twoSum(int[] numbers, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        HashMap<Integer, Integer> mp = new HashMap<Integer, Integer>();
        int[] answer = new int[2];
        if(numbers.length < 2) return answer;
        for(int i = 0; i  < numbers.length; i++) mp.put(numbers[i], i);
        for(int i = 0; i < numbers.length; i++)
            if(mp.get(target - numbers[i]) != null && mp.get(target - numbers[i]) != i){
                answer[0] = i + 1;
                answer[1] = mp.get(target - numbers[i]) + 1;
                break;
            }
        return answer;
    }
}
