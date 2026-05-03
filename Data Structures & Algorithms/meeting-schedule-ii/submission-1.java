/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    class Pair{
        int t;
        int e;
    }
    public int minMeetingRooms(List<Interval> intervals) {
        Pair time[] = new Pair[2*intervals.size()];
        int i=0;
        
        for(Interval interval:intervals){
            Pair p = new Pair();
            p.t=interval.start;
            p.e=1;
            time[i++]=p;
             p = new Pair();
            p.t=interval.end;
            p.e=-1;
            time[i++]=p;
            
        }
        Arrays.sort(time,(a,b)->{
            if(a.t==b.t){
                return a.e-b.e;
            }
            return a.t-b.t;
        });

        
        int ans=0,rooms=0;
        for(i=0;i<time.length;i++){
            rooms+=time[i].e;
            ans=Math.max(ans,rooms);
        }
        return ans;

    }
}
