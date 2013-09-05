public class Solution {
    public String convert(String s, int nRows) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(nRows == 1) return s;
        ArrayList<StringBuilder> answer = new ArrayList<StringBuilder>(nRows);
        for(int i = 0; i < nRows; i++) answer.add(new StringBuilder());
        for(int row = 0, d = 1, i = 0; i < s.length(); i++, row += d){
            if(row == 0) d = 1;
            if(row == nRows - 1) d = -1;
            answer.get(row).append(s.charAt(i));
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < nRows; i++) sb.append(answer.get(i).toString());
        return sb.toString();
    }
}
