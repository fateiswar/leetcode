public class Solution {
    public ArrayList<Integer> findSubstring(String S, String[] L) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<Integer> answer = new ArrayList<Integer>();
        if(S == null || S.length() == 0) return answer;
        if(L == null || L.length == 0){
            for(int i = 0; i < S.length(); i++)
                answer.add(i);
            return answer;
        }
        HashMap<String, Integer> mp = new HashMap<String, Integer>();
        for(int i = 0; i < L.length; i++){
            if(mp.get(L[i]) == null)
                mp.put(L[i], 1);
            else
                mp.put(L[i], mp.get(L[i]) + 1);
        }
        HashMap<String, Integer> tmp = new HashMap<String, Integer>();
        for(int i = 0; i < S.length(); i++) if(i + L.length * L[0].length() <= S.length()){
            int j = 0;
            tmp.clear();
            for(j = 0; j < L.length; j++){
                String curr = S.substring(i + j * L[0].length(), i + (j + 1) * L[0].length());
                if(mp.get(curr) == null) break;
                if(tmp.get(curr) == null)
                    tmp.put(curr, 1);
                else if(tmp.get(curr) == mp.get(curr))
                    break;
                else tmp.put(curr, tmp.get(curr) + 1);
            }
            if(j == L.length) answer.add(i);
        }
        return answer;
    }
}
