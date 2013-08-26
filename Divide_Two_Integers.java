public class Solution {
    public int divide(int dividend, int divisor) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int sign = 1;
        long _dividend = dividend;
        long _divisor = divisor;
        if(_dividend < 0) { _dividend = -_dividend; sign = -sign; }
        if(_divisor < 0) { _divisor = -_divisor; sign = -sign; }
        if(_divisor > _dividend) return 0;
        int high = 0;
        while((_divisor << (high+1)) <= _dividend)
            high++;
        long answer = 0;
        for(int i = high; i >= 0; i--){
            if(_dividend >= (_divisor << i)){
                answer += (1L << i);
                _dividend -= (_divisor << i);
            }
        }
        return (int)answer * sign;
    }
}
