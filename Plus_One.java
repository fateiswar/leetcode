public class Solution {
    public int[] plusOne(int[] digits) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(digits.length == 0){
            int[] answer = new int[1];
            answer[0] = 1;
            return answer;
        }
        int carry = 1;
        for(int i = digits.length - 1; i >= 0; i--){
            carry += digits[i];
            digits[i] = carry % 10;
            carry /= 10;
        }
        if(carry == 0) return digits;
        int[] answer = new int[digits.length + 1];
        answer[0] = 1;
        for(int i = 0; i < digits.length; i++)
            answer[i+1] = digits[i];
        return answer;
    }
}
