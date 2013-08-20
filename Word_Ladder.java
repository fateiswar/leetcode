public class Solution {
    public int ladderLength(String start, String end, HashSet<String> dict) {
        // Start typing your Java solution below
        // DO NOT write main() function
        dict.add(start);
        dict.add(end);
        HashMap<String, Integer> dist = new HashMap<String, Integer>();
        dist.put(end, 0);
        if(start.equals(end)) return 2;
        LinkedList<String> Q = new LinkedList<String>();
        Q.offer(end);
        while(Q.size() != 0){
            String curr = Q.poll();
            int d = dist.get(curr);
            char[] s = curr.toCharArray();
            for(int i = 0; i < s.length; i++){
                char c = s[i];
                for(char j = 'a'; j <= 'z'; j++)if(c != j){
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
        if(dist.get(start) == null) return 0;
        return dist.get(start) + 1;
    }
}
