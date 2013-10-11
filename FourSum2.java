
class Pair implements Comparable<Pair>{
    public int idx1, idx2, num1, num2, sum;
    public int compareTo(Pair o2){
        if(sum != o2.sum) return sum - o2.sum;
        if(idx1 != o2.idx1) return idx1 - o2.idx1;
        return idx2 - o2.idx2;
    }
    public Pair(int _idx1, int _idx2, int _num1, int _num2, int _sum){
        idx1 = _idx1;
        idx2 = _idx2;
        num1 = _num1;
        num2 = _num2;
        sum  = _sum;
    }
}
public class Solution {
    public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> answer = new ArrayList<ArrayList<Integer>>();
        if(num == null || num.length < 4) return answer;
        Arrays.sort(num);
        ArrayList<Pair> A = new ArrayList<Pair>(num.length * num.length);
        for(int i = 0; i < num.length; i++)
            for(int j = i + 1; j < num.length; j++)
                A.add(new Pair(i, j, num[i], num[j], num[i] + num[j]));
        Collections.sort(A);
        int left = 0, right = A.size() - 1;
        while(left < right){
            if(right < A.size() - 1&& A.get(right).num1 == A.get(right + 1).num1 && A.get(right).num2 == A.get(right + 1).num2){
                right--;
                continue;
            }
            if(left > 0 && A.get(left).num1 == A.get(left - 1).num1 && A.get(left).num2 == A.get(left - 1).num2){
                left++;
                continue;
            }
            if(A.get(left).sum + A.get(right).sum > target)
                right--;
            else if(A.get(left).sum + A.get(right).sum < target)
                left++;
            else if(A.get(left).idx2 < A.get(right).idx1)
            {
                for(int i = right; i > left && A.get(i).sum == A.get(right).sum && A.get(i).idx1 > A.get(left).idx2; i--){
                    if(i < right && A.get(i).num1 == A.get(i + 1).num1) continue;
                    ArrayList<Integer> sub = new ArrayList<Integer>(4);
                    sub.add(A.get(left).num1);
                    sub.add(A.get(left).num2);
                    sub.add(A.get(i).num1);
                    sub.add(A.get(i).num2);
                    answer.add(sub);
                }
                left++;
            }else left++;
        }
        return answer;
    }
}
