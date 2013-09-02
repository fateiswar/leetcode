public class Solution {
    public ArrayList<Integer> getRow(int rowIndex) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<Integer> curr = new ArrayList<Integer>(rowIndex + 1),
                            next = new ArrayList<Integer>(rowIndex + 1);
        for(int i = 0; i <= rowIndex; i++){
            next.clear();
            next.add(1);
            for(int j = 1; j < i ;j++)
                next.add(curr.get(j) + curr.get(j - 1));
            if(i != 0) next.add(1);
            ArrayList<Integer> tmp = curr;
            curr = next;
            next = tmp;
        }
        return curr;
    }
}
