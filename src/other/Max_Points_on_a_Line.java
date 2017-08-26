package other;

import java.util.HashMap;
import java.util.Map;

/**第149
 * Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
 *
 * Created by zhaoshiqiang on 2017/2/14.
 */
//循环遍历
public class Max_Points_on_a_Line{
    /*解法一：
    *   比较直观的方法是，三层循环，以任意两点划线，判断第三个点是否在这条直线上。
    * 解法二：
    *   选定一个点，分别计算其他点和它构成的直线的斜率，斜率相同的点肯定在同一条直线上。
    *   计算斜率时，注意重合点和x值相同的两个点（数学上称斜率不存在，此时斜率用int的最大值表示）。下面用的就是这个方法
    * */
    public static int maxPoints(Point[] points) {
        if (points.length < 3) return points.length;

        int max = 0;//用于返回的结果，即共线点的最大个数
        Map<Double, Integer> map = new HashMap<Double, Integer>();//保存同一个斜率的点的个数

        for (int i = 0; i < points.length; i++) {//以每一个点为固定点
            map.clear();
            int duplicate = 1;//记录跟固定点重合的个数

            for(int j = 0 ; j < points.length; j++){//遍历其他点，求其与固定点之间的斜率
                if (i == j) continue;//如果是自己，跳过
                double slope = 0.0;//斜率

                if (points[i].x == points[j].x && points[i].y == points[j].y) {//如果跟固定点重合
                    duplicate++;
                    continue;
                } else if (points[i].x == points[j].x) {//如果跟固定点在同一条竖线上，斜率设为最大值
                    slope = Integer.MAX_VALUE;
                } else {//计算该点与固定点的斜率
                    slope = (double)(points[i].y - points[j].y) / (points[i].x - points[j].x);
                }
                map.put(slope, map.containsKey(slope) ? map.get(slope) + 1 : 1);
            }

            //更新最优解
            if (map.keySet().size() == 0) {//如果map为空
                max = duplicate > max ? duplicate : max;
            } else {
                for (double key : map.keySet()) {
                    max = Math.max((duplicate + map.get(key)), max);
                }
            }
        }
        return max;
    }

    static class Point {
        int x;
        int y;

        Point() {
            x = 0;
            y = 0;
        }

        Point(int a, int b) {
            x = a;
            y = b;
        }
    }

    public static void main(String[] args){
        Point[] points = new Point[]{new Point(0,0),new Point(94911151,94911150),new Point(94911152,94911151)};
        System.out.println(maxPoints(points));
    }
}