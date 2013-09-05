public class Solution {
    public String intToRoman(int num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        HashMap<Integer, Character> mp = new HashMap<Integer, Character>();
        mp.put(1, 'I'); mp.put(5, 'V'); mp.put(10, 'X'); mp.put(50, 'L');
        mp.put(100, 'C'); mp.put(500, 'D'); mp.put(1000, 'M');
        int p1 = 1000, p2 = 5000, p3 = 10000;
        StringBuilder sb = new StringBuilder();
        for(; p1 > 0; ){
            if(num % p1 == num){
                p1 /= 10;
                p2 /= 10;
                p3 /= 10;
                continue;
            }
            if(num / p1 == 9){
                sb.append(mp.get(p1));
                sb.append(mp.get(p3));
            }else if(num / p1 >= 5){
                sb.append(mp.get(p2));
                for(int i = 1; i <= num / p1 - 5; i++) sb.append(mp.get(p1));
            }else if(num / p1 == 4){
                sb.append(mp.get(p1));
                sb.append(mp.get(p2));
            }else{
                for(int i = 1; i <= num / p1; i++) sb.append(mp.get(p1));
            }
            num %= p1;
        }
        return sb.toString();
    }
}
