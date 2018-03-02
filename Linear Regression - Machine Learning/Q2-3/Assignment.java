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
   *   add the sample [(i, 2i), 5i] for 0&lt;=i&lt;=999
   *   add the sample [(2i, i), 4i] for 0&lt;=i&lt;=999
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
    
    // your code goes there
    
  }
  
  /** 
   * In this third method, we will follow the same approach
   * that the one followed in the method  randomPlane, but
   * this time we will have a variable number of dimensions,
   * specified by the parameter "dimension". We will
   * create 5000 samples of "dimension" dimension, where each
   * dimension will be ranmly selected between  -100 and +100,
   * and a randomly selected noise between -20 and +20 will be
   * added to the result.We will then iterate gradient descent 
   * (find a number of iterations,
   * and a step alpha that seems to work, regularly printing
   * the target,  the current hypothesis and the current cost)
   *
   * @param dimension the number of features
   */
  private static void randomDimension(int dimension){
    LinearRegression linear = new LinearRegression(dimension, 5000);
    double r = 0.0;
    double[] x = new double[dimension];
    int[] t = new int[dimension + 1];
    String equation = "";
    for(int i = 0; i <= dimension; i++) {
      t[i] = generator.nextInt(100) - 100;
    }
    r += t[0];
    equation += Integer.toString(t[0]);
    for(int i = 0; i < dimension; i++) {
      x[i] = generator.nextInt(4000) - 50;
      for(int j = 1; j <= dimension; j++) {
        r += t[j] * x[i];
        equation += (Integer.toString(t[j]) + "x_" + i);
      }
    }
    r = r + generator.nextInt(20) - 20;
    for(int i = 0; i < 5000; i++) {
      linear.addSample(x, r);
    }
    for(int i = 0; i < 10; i++) {
      System.out.println(linear.currentHypothesis());
      System.out.println(linear.currentCost());
      System.out.println("Aiming for: " + equation);
      linear.gradientDescent(0.00000003, 1);
    }
  }
  
  
  public static void main(String[] args) {
    
    StudentInfo.display();
    
    System.out.println("randomDimension");
    randomDimension(50);
    
    
  }
  
}