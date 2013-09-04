public class Solution {
    public String multiply(String num1, String num2) {
        // Start typing your Java solution below
        // DO NOT write main() function
        char[] n1 = num1.toCharArray();
        char[] n2 = num2.toCharArray();
        int[] result = new int[n1.length + n2.length];
        int carry = 0;
        for(int i = n1.length - 1; i >= 0; i--)
            for(int j = n2.length -1; j >= 0; j--)
                result[n1.length - 1 - i + n2.length - 1 - j] += (n1[i] - '0') * (n2[j] - '0');
        for(int i = 0; i < n1.length + n2.length; i++){
            carry += result[i];
            result[i] = carry % 10;
            carry /= 10;
        }
        int i = n1.length + n2.length - 1;
        for(; i >= 0 && result[i] == 0; i--);
        if(i < 0) return "0";
        StringBuilder sb = new StringBuilder();
        for(; i >= 0; i--)
            sb.append(result[i]);
        return sb.toString();
    }
}
