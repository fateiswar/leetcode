public class Solution {
    ArrayList<ArrayList<String>> answer;
    boolean[][] pal;
    LinkedList<String> Q;
    void dfs(String s, int p){
        if(p == s.length()){
            ArrayList<String> sub = new ArrayList<String>();
            for(Iterator<String> it = Q.iterator(); it.hasNext(); ){
                sub.add(it.next());
            }
            answer.add(sub);
            return;
        }
        for(int i = p; i < s.length(); i++) if(pal[p][i]){
            Q.offer(s.substring(p, i+1));
            dfs(s, i + 1);
            Q.pollLast();
        }
    }
    public ArrayList<ArrayList<String>> partition(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        answer = new ArrayList<ArrayList<String>>();
        if(s.length() == 0){
            ArrayList<String> sub = new ArrayList<String>();
            sub.add("");
            answer.add(sub);
            return answer;
        }
        int len = s.length();
        pal = new boolean[len][len];
        for(int i = 0;i < len ;i++) pal[i][i] = true;
        for(int i = 1; i < len; i++) pal[i][i-1] = true;
        for(int l = 1; l < len; l++)
            for(int i = 0; i + l < len; i++)
                pal[i][i + l] = (s.charAt(i) == s.charAt(i + l) && pal[i + 1][i + l -1]);
        Q = new LinkedList<String>();
        dfs(s, 0);
        return answer;
    }
}
