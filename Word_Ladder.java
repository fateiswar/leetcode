public class Solution {
    
    public boolean conn(String a, String b){
        if(a.length() != b.length()) return false;
        int diff = 0;
        for(int i = 0; i < a.length() && diff < 2; i++)
            diff += (a.charAt(i) != b.charAt(i) ? 1:0);
        return diff == 1;
    }
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
            int d = mp.get(curr);
            for(String next : dict) if(conn(curr, next) && dist.get(next) == null){
                dist.put(next, d + 1);
                Q.offer(next);
            }
        }
        return mp.get(start) + 1;
    }
}
