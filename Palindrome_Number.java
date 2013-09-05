public class Solution {
    public boolean isPalindrome(int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
        long n = x;
        if(n < 0) return false;
        if(n < 10) return true;
        long maxBit = 1;
        for(; n % maxBit != n; maxBit *= 10);
        maxBit /= 10;
        while(n >= 10){
            if(n % 10 != n / maxBit) return false;
            n = n % maxBit / 10;
            maxBit /= 100;
        }
        return true;
    }
}
