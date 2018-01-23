//Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.

import java.util.HashMap;

public class Leetcode149 {
    public static void main(String args[]) {
        Point point1 = new Point(0,0);
        Point point2 = new Point(1,1);
        Point point3 = new Point(0,0);
        Point[] points = {point1, point2, point3};
        int result = maxPoints(points);
        System.out.println(result);
    }

    public static int maxPoints(Point[] points) {
        if(points == null || points.length == 0) return 0;
        if(points.length<2) return points.length;
        int res = 0;
        for(int i=0; i<points.length-1; i++) {
            HashMap<String, Integer> map = new HashMap<>();
            int samePoint = 1;
            int sameXAxis = 0;
            for(int j=i+1; j<points.length; j++) {
                if(points[i].x == points[j].x && points[i].y == points[j].y) {
                    samePoint++;
                }else if(points[i].x == points[j].x) {
                    sameXAxis++;
                } else {
                    int numerator = points[j].y - points[i].y;
                    int denominator = points[j].x - points[i].x;
                    int gcd = gcd(numerator, denominator);
                    String key = (numerator / gcd) + "/" + (denominator / gcd);
                    map.put(key, map.getOrDefault(key, 0) + 1);
                }
            }
            int localMax = 0;
            for(String key : map.keySet()) {
                localMax = Math.max(localMax, map.get(key));
            }
            localMax = Math.max(localMax, sameXAxis);
            res = Math.max(res, localMax+samePoint);
        }
        return res;
    }

    private static int gcd(int a, int b) {
        if(a==0) return b;
        return gcd(b%a, a);
    }

    static class Point {
        int x;
        int y;
        Point() { x = 0; y = 0; }
        Point(int a, int b) { x = a; y = b; }
    }

}
