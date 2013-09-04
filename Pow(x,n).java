public class Solution {
    public double pow(double x, int nn) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(nn == 0) return 1;
        int sign = 1;
        long n = nn;
        if(n < 0){
            sign = -1;
            n = -n;
        }
        double a = 1, b = x;
        while(n > 0){
            if((n&1) == 1){
                a *= b;
            }
            n >>= 1;
            b = b*b;
        }
        if(sign > 0) return a;
        return 1.0 / a;
    }
}
