import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 第56
 * Given a collection of intervals, merge all overlapping intervals.
     For example,
     Given [1,3],[2,6],[8,10],[15,18],
     return [1,6],[8,10],[15,18].
 * @Author: zhaoshiqiang
 * @Date Create in 9:26 2017/8/19
 */
public class Merge_Intervals {

    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> ret = new ArrayList<>();
        if (intervals.size() == 0){
            return ret;
        }
        List<item> items = new ArrayList<>();
        for (Interval x : intervals){
            items.add(new item(x.start,x.end));
        }
        Collections.sort(items);
        item section = items.get(0);
        for (int i = 1; i < items.size(); i++) {
            item a = items.get(i);
            if (a.x > section.y){
                ret.add(new Interval(section.x,section.y));
                section = a;
                continue;
            }else if (a.y > section.y){
                section.y = a.y;
                continue;
            }
        }
        ret.add(new Interval(section.x,section.y));
        return ret;
    }

    public class Interval {
          int start;
          int end;
          Interval() { start = 0; end = 0; }
          Interval(int s, int e) { start = s; end = e; }
    }
    static class item implements Comparable{
        Integer x, y;

        public item(Integer x, Integer y) {
            if (x<y){
                this.x = x;
                this.y = y;
            }else {
                this.y = x;
                this.x = y;
            }
        }

        @Override
        public int compareTo(Object o) {
            item i = (item) o;
            if (i.x > this.x){
                return -1;
            }else if (i.x == this.x){
                return 0;
            }else {
                return 1;
            }
        }
    }
}
