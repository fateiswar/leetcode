public class Solution {
    public int reverse(int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int sign = 1;
        long n = x;
        if(n < 0){
            sign = -1;
            n = -n;
        }
        long answer = 0;
        while(n > 0){
            answer = answer * 10 + n % 10;
            n /= 10;
        }
        return (int)(sign * answer);
    }
}
