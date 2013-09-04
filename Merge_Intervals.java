/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
 class cmp implements Comparator<Interval>{
     public int compare(Interval a, Interval b){
         if(a.start != b.start)
            return a.start < b.start ? -1 : 1;
        return a.end == b.end ? 0 : (a.end < b.end ? -1 : 1);
     }
 }
public class Solution {
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<Interval> answer = new ArrayList<Interval>();
        if(intervals == null || intervals.size() == 0) return answer;
        Collections.sort(intervals, new cmp());
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;
        for(int i = 1; i < intervals.size(); i++)
            if(end < intervals.get(i).start){
                answer.add(new Interval(start, end));
                start = intervals.get(i).start;
                end = intervals.get(i).end;
            }else{
                end = Math.max(end, intervals.get(i).end);
            }
        answer.add(new Interval(start, end));
        return answer;
    }
}
