public class Solution {
    ArrayList<String> answer;
    char[][] adj = new char[][]{ {' '}, {}, {'a', 'b', 'c'}, {'d', 'e', 'f'},
                                {'g', 'h', 'i'}, {'j', 'k', 'l'}, {'m', 'n', 'o'},
                                {'p', 'q', 'r', 's'}, {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}
    };
    void formSol(ArrayList<Character> path){
        if(path.size() == 0){
            answer.add("");
            return;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < path.size(); i++)
            sb.append(path.get(i));
        answer.add(sb.toString());
    }
    void dfs(char[] digits, int pos, ArrayList<Character> path){
        if(pos == digits.length){
            formSol(path);
            return;
        }
        int cur = digits[pos] - '0';
        for(int i = 0; i < adj[cur].length; i++){
            path.add(adj[cur][i]);
            dfs(digits, pos + 1, path);
            path.remove(path.size() - 1);
        }
    }
    public ArrayList<String> letterCombinations(String digits) {
        // Start typing your Java solution below
        // DO NOT write main() function
        answer = new ArrayList<String>();
        ArrayList<Character> path = new ArrayList<Character>();
        dfs(digits.toCharArray(), 0, path);
        return answer;
    }
}
