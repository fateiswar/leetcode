/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<Interval> answer = new ArrayList<Interval>();
        if(intervals == null || intervals.size() == 0){
            answer.add(newInterval);
            return answer;
        }
        int start = newInterval.start;
        int end = newInterval.end;
        boolean inserted = false;
        for(int i = 0; i < intervals.size(); i++){
            if(inserted) answer.add(intervals.get(i));
            else{
                if(end < intervals.get(i).start){
                    answer.add(new Interval(start, end));
                    i--;
                    inserted = true;
                }else if(start > intervals.get(i).end){
                    answer.add(intervals.get(i));
                }else{
                    start = Math.min(start, intervals.get(i).start);
                    end = Math.max(end, intervals.get(i).end);
                }
            }
        }
        if(!inserted) answer.add(new Interval(start, end));
        return answer;
    }
}
