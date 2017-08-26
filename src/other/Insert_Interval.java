package other;

import java.util.ArrayList;
import java.util.List;

/**
 * 第57
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

     You may assume that the intervals were initially sorted according to their start times.

     Example 1:
     Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].

     Example 2:
     Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].

     This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
 * Create by zhaoshiqiang on 14:00 2017/8/19
 */
public class Insert_Interval {

    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> res = new ArrayList<Interval>();

        for (Interval interval : intervals){
            //interval的end小于newInterval的start时，说明新的区间在当前遍历到的区间的后面，并且没有重叠，所以res添加当前的interval；
            if (interval.end < newInterval.start){
                res.add(interval);
            }else if (interval.start > newInterval.end){
                //interval的start大于newInterval的end时，说明新的区间比当前遍历到的区间要前面，并且也没有重叠，所以把newInterval添加到res里
                res.add(newInterval);
                //这里直接将newInterval更新为interval，是为了将合并后的newInterval插入正确的位置，避免后面的排序
                newInterval=interval;
            }else {
                //interval与newInterval有重叠时，merge interval并更新新的newInterval为merge后的。
                int newstart = Math.min(newInterval.start,interval.start);
                int newend = Math.max(newInterval.end,interval.end);
                newInterval = new Interval(newstart,newend);
            }
        }
        res.add(newInterval);
        return res;
    }

    public class Interval {
          int start;
          int end;
          Interval() { start = 0; end = 0; }
          Interval(int s, int e) { start = s; end = e; }
    }
}
