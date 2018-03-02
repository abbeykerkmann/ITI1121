//Abbey Kerkmann, 300007054, Section B
//Ryan Matte, 300027432, Section B

/**
 * The class  <b>Assignment</b> is used to
 * test our LinearRegression class. 
 *
 * @author gvj (gvj@eecs.uottawa.ca)
 *
 */

public class Assignment {
  
  
  /** 
   * Random generator 
   */
  private static java.util.Random generator = new java.util.Random();
  
  /** 
   * In this first method, we are simply using sample points that are
   * on a straight plane. We will use the plane z= x + 2x.
   * In his method, 
   *  1) we create an instance of LinearRegression.
   *  2) we add 2,000 samples from the plane z= x + 2x as follows:
   *   add the sample [(i, 2i), 5i] for 0<=i<=999
   *   add the sample [(2i, i), 4i] for 0<=i<=999
   *  3) we iterate gradient descent 10,000, printing out the
   * current hypothesis and the current cost every 1,000 
   * iterations, using a step alpha of 0.000000003
   */
  private static void setPlane(){
    
    // your code goes there
    
  }
  
  /** 
   * In this second method, we will select a plane at random.
   *  1) we select a line z = ax + by + c, with a, b and c 
   * randomly selected between -100 and +100 
   *  2) we add 5000 samples randomly selected on the plane
   * with x and y both randomly selected between 50 and 4000. 
   * For each sample we add a "noise" 
   * randomly selected between -20 and +20 (that is, for
   * each randomly selected x and y we add the sample 
   *[ (x,y), ax+by+c+noise).
   * where "noise" is randomly selected between -20 and 20
   *  4) we iterate gradient descent (find a number of iterations,
   * and a step alpha that seems to work, regularly printing
   * the target,  the current hypothesis and the current cost)
   */
  
  private static void randomPlane(){
    LinearRegression linear = new LinearRegression(2, 5000);
    int a = generator.nextInt(101) - 100;
    int b = generator.nextInt(101) - 100;
    int c = generator.nextInt(101) - 100;
    int x1 = generator.nextInt(4001) - 50;
    int x2 = generator.nextInt(4001) - 50;
    double[] x = {1, x1, x2};
    int delta = generator.nextInt(20) - 20;
    int z = a*x1 + b*x2 + c + delta;
    for(int i = 0; i < 5000; i++) {
      linear.addSample(x, z);
    }
    for(int i = 0; i < 10; i++) {
      System.out.println(linear.currentHypothesis());
      System.out.println(linear.currentCost());
      linear.gradientDescent(0.0000003, 1000);
    }
  }
  
  
  public static void main(String[] args) {
    
    StudentInfo.display();
    
    System.out.println("randomPlane");
    randomPlane();
    
    
    
  }
  
}