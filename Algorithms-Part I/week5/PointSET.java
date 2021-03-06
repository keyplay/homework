import java.util.Iterator;
import java.lang.NullPointerException; 
import java.util.TreeSet;
import java.util.ArrayList;
import java.util.List;
import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.RectHV;
import edu.princeton.cs.algs4.StdDraw;

public class PointSET {
    private TreeSet<Point2D> points;
    
    public PointSET() {                               // construct an empty set of points 
        points = new TreeSet<Point2D>();
    }
    
    public boolean isEmpty() {                     // is the set empty? 
        return points.isEmpty();
    }
    
    public int size() {                        // number of points in the set 
        return points.size();
    }
    
    public void insert(Point2D p) {             // add the point to the set (if it is not already in the set)
        if (p == null) {
            throw new NullPointerException();
        }
        points.add(p);
    }
    
    public boolean contains(Point2D p) {           // does the set contain point p? 
        if (p == null) {
            throw new NullPointerException();
        }   
        return points.contains(p);
    }
    
    public void draw() {                        // draw all points to standard draw 
        for (Point2D point : points) {
            StdDraw.point(point.x(), point.y());
        }
    }
    
    public Iterable<Point2D> range(RectHV rect) {            // all points that are inside the rectangle 
        if (rect == null) {
            throw new NullPointerException();
        }  

        List<Point2D> result = new ArrayList<>();
        for (Point2D point : points) {
            if (rect.contains(point)) {
                result.add(point);
            }
        }
        
        return result;
    }
    
    public Point2D nearest(Point2D p) {            // a nearest neighbor in the set to point p; null if the set is empty 
        if (p == null) {
            throw new NullPointerException();
        }
        
        Point2D nearestPoint = null;
        for (Point2D point : points) {
            if (nearestPoint == null || nearestPoint.distanceTo(p) > point.distanceTo(p)) {
                nearestPoint = point;
            }
        }
        
        return nearestPoint;
    }
    
    public static void main(String[] args)                  // unit testing of the methods (optional) 
}
