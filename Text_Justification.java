public class Solution {
    public ArrayList<String> fullJustify(String[] words, int L) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<String> answer = new ArrayList<String>();
        if(words == null) return answer;
        int i = 0, j = 0, k = 0;
        for(i = 0; i < words.length; i = j){
            int len = words[i].length();
            for(j = i + 1; j < words.length && len + words[j].length() + 1 <= L; j++)
                len += words[j].length() + 1;
            int spaces = L - len + (j - i - 1);
            StringBuilder sb = new StringBuilder();
            for(k = i; k < j; k++){
                sb.append(words[k]);
                if(k != j - 1 && j == words.length){
                    sb.append(' ');
                    spaces--;
                }else if(k != j - 1){
                    for(int u = 1; u <= (spaces + j - k - 2) / (j - k - 1); u++)
                        sb.append(' ');
                    spaces -= (spaces + j - k - 2) / (j - k - 1);
                }
            }
            for(k = 1; k <= spaces; k++) sb.append(' ');
            answer.add(sb.toString());
        }
        return answer;
    }
}
