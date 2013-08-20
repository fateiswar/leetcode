public class Solution {
    ArrayList<ArrayList<String>> answer;
    HashMap<String, Integer> dist;
    void dfs(String end, String curr, ArrayList<String> sub){
        if(end.equals(curr)){
            answer.add((ArrayList<String>)sub.clone());
            return;
        }
        char[] s = curr.toCharArray();
        for(int i = 0; i < s.length; i++){
            char c = s[i];
            for(char j = 'a'; j <= 'z'; j++)if(j != c){
                s[i] = j;
                String next = new String(s);
                if(dist.get(next) != null && dist.get(next) + 1 == dist.get(curr)){
                    sub.add(next);
                    dfs(end, next, sub);
                    sub.remove(sub.size() - 1);
                }
            }
            s[i] = c;
        }
    }
    public ArrayList<ArrayList<String>> findLadders(String start, String end, HashSet<String> dict) {
        // Start typing your Java solution below
        // DO NOT write main() function
        answer = new ArrayList<ArrayList<String>>();
        dict.add(start);
        dict.add(end);
        if(start.equals(end)){
            ArrayList<String> sub = new ArrayList<String>();
            sub.add(start);
            sub.add(end);
            answer.add(sub);
            return answer;
        }
        LinkedList<String> Q = new LinkedList<String>();
        dist = new HashMap<String, Integer>();
        dist.put(end, 0);
        Q.offer(end);
        while(Q.size() != 0){
            String curr = Q.poll();
            int d = dist.get(curr);
            char[] s = curr.toCharArray();
            for(int i = 0; i < s.length; i++){
                char c = s[i];
                for(char j = 'a'; j <= 'z'; j++) if(c != j){
                    s[i] = j;
                    String next = new String(s);
                    if(dict.contains(next) && dist.get(next) == null){
                        dist.put(next, d + 1);
                        Q.offer(next);
                    }
                }
                s[i] = c;
            }
        }
        if(dist.get(start) == null) return answer;
        ArrayList<String> sub = new ArrayList<String>();
        sub.add(start);
        dfs(end, start, sub);
        return answer;
    }
}
