//A move consists of taking a point (x, y) and transforming it to either (x, x+y) or (x+y, y).
//Given a starting point (sx, sy) and a target point (tx, ty),
//return True if and only if a sequence of moves exists to transform the point (sx, sy) to (tx, ty). Otherwise, return False.

public class Leetcode780 {
    public static void main(String args[]) {
        boolean result = reachingPoints(1,1,3,5);
        System.out.println(result);
    }

    public static boolean reachingPoints(int sx, int sy, int tx, int ty) {
        while(tx>=sx && ty>=sy) {
            if(tx > ty) {
                if(sy == ty) return (tx-sx)%ty == 0;
                tx %= ty;
            } else {
                if(sx == tx) return (ty-sy)%tx == 0;
                ty %= tx;
            }
        }
        return false;
    } 

}
