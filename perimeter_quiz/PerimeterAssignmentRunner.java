import edu.duke.*;
import java.io.File;

public class PerimeterAssignmentRunner {
    public int getNumPoints (Shape s) {
        // Put code here
        int count = 0;
        
        for (Point p: s.getPoints()){
            count = count + 1;
            System.out.println(p);
        }
        return count;
    }
    public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim;
    }

    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        System.out.println("perimeter = " + length);
        double aveLength = getAverageLength(s);
        System.out.println("The average side length = " + aveLength);
        double largestSide = getLargestSide(s);
        System.out.println ("The largest size of sides is = "+ largestSide);
        double largestX = getLargestX(s);
        System.out.println("The largest X of the points is = "+ largestX);
    }
    public double getAverageLength(Shape s) {
        // Put code here
        int count = getNumPoints(s);
        double perim = getPerimeter(s);
        return perim/count;
    }

    public double getLargestSide(Shape s) {
        // Put code here
        // Start with maxLength = 0
        double maxLength = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // compare and update maximum length of sides
            if (currDist >= maxLength){
                maxLength = currDist;
            }
            else
                {
                maxLength = maxLength;
                }
            //maximum length is changed;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // maximum length is the answer
        return maxLength;        
    }

    public double getLargestX(Shape s) {
        // Put code here
        int bigX = 0;
        
        for (Point currPt:s.getPoints()){
         if (bigX > currPt.getX()){
             bigX = bigX;
            }
         else {
             bigX = currPt.getX();
            }
        }
        return bigX;
    }

    public double getLargestPerimeterMultipleFiles() {
        // Put code here
        double largestPerim = 0.0;
        DirectoryResource dr = new DirectoryResource();
        for (File f:dr.selectedFiles()){
                FileResource fr = new FileResource(f);
                Shape s = new Shape (fr);
                double totalPerim = getPerimeter (s);
                
          if (totalPerim > largestPerim){
            largestPerim = totalPerim;
           }
           else{
            largestPerim = largestPerim;
           }
        
        }
        return largestPerim;
    }

    public String getFileWithLargestPerimeter() {
        // Put code here
        File temp = null;    // replace this code
        double largestPerim = 0.0;
        DirectoryResource dr = new DirectoryResource();
        for (File f:dr.selectedFiles()){
                FileResource fr = new FileResource(f);
                Shape s = new Shape (fr);
                double totalPerim = getPerimeter (s);
                
          if (totalPerim > largestPerim){
            largestPerim = totalPerim;
            temp = f;
           }
           else{
            largestPerim = largestPerim;
            temp = temp;
           }
        
        }
        return temp.getName();
    }

    public void testPerimeterMultipleFiles() {
        // Put code here
        DirectoryResource dr = new DirectoryResource ();
        double largestPerimeter = getLargestPerimeterMultipleFiles ();
        System.out.println("the largest perimeter in the directory is = " + largestPerimeter);    
    }

    public void testFileWithLargestPerimeter() {
        // Put code here
        DirectoryResource dr = new DirectoryResource ();
        String S = getFileWithLargestPerimeter();
        System.out.println("The file with the largest perimeter size is " + S);
    }

    // This method creates a triangle that you can use to test your other methods
    public void triangle(){
        Shape triangle = new Shape();
        triangle.addPoint(new Point(0,0));
        triangle.addPoint(new Point(6,0));
        triangle.addPoint(new Point(3,6));
        for (Point p : triangle.getPoints()){
            System.out.println(p);
        }
        double peri = getPerimeter(triangle);
        int numberOfPoints = getNumPoints(triangle);
        double aveLength = getAverageLength(triangle);
        System.out.println("number of points/sides = " + numberOfPoints);
        System.out.println("perimeter = "+peri);
        System.out.println("The average side length = " + aveLength);
    }

    // This method prints names of all files in a chosen folder that you can use to test your other methods
    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println(f);
        }
    }

    public static void main (String[] args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        pr.testPerimeter();
    }
}
