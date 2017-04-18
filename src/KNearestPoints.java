import java.util.*;

/**
 * Created by letian on 4/18/17.
 */
public class KNearestPoints {


    private double getDistance(Point a) {
        return a.x * a.x + a.y * a.y;
    }

    public List<Point> findKNearestPoints (List<Point> list, int k) {
        if (list == null || k < 0)
            return null;

        if (list.size() < k)
            return list;

        Comparator<Point> cp = (o1, o2) -> {
            if (getDistance(o1) > getDistance(o2))
                return -1;
            else if (getDistance(o1) < getDistance(o2))
                return 1;
            return 0;
        };
        System.out.println(cp.compare(new Point(0,2), new Point(0,3)));
        PriorityQueue<Point> queue = new PriorityQueue<>(k, cp);

        if (k > 0) {
            for (Point p : list) {
                queue.add(p);
                if (queue.size() > k) {
                    queue.poll();
                }
            }
        }

        System.out.println(queue.toString());

        return new ArrayList<>(queue);
    }

    public static void main(String[] args) {
        KNearestPoints sol = new KNearestPoints();
        List<Point> list = new LinkedList<>();

        list.add(new Point(0,1));
        list.add(new Point(0,2));
        list.add(new Point(0,3));
        list.add(new Point(0,5));
        list.add(new Point(0,6));
        list.add(new Point(0,7));

        for (Point p : sol.findKNearestPoints(list, 3))
            System.out.println(p.x + " " + p.y);
    }
}

class Point {
    double x;
    double y;
    Point (double a, double b) {
        x = a;
        y = b;
    }


    public String toString() {
        return x + " " + y;
    }
}
