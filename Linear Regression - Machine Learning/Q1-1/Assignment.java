//Abbey Kerkmann, 300007054, Section B
//Ryan Matte, 300027432, Section B

public class Assignment {
  /** 
   * In this first method, we are simply using sample points that are
   * on a straight line, namely y = x;
   * In his method, 
   *  1) we create an instance of LinearRegression.
   *  2) we add 1,000 samples (from 0 to 999) from the line y=x
   *  3) We create an instance of Display
   *  4) we iterate gradient descent 5,000, updating the instance
   * of Display every 100 iteration, using a step alpha of 0.000000003
   */
  
  private static void setLine(){
    LinearRegression linear = new LinearRegression(1000);
    for(int i = 0; i < 1000; i++) {
      linear.addSample(i, i);
    }
    Display display = new Display(linear);
    for(int i = 0; i < 50; i++) {  
      System.out.println(linear.currentHypothesis());
      System.out.println(linear.currentCost());
      display.update(); 
      linear.gradientDescent(0.000000003, 100);  
    }
  }  
  
  public static void main(String[] args) {
    
    StudentInfo.display();
    
    System.out.println("setLine");
    setLine();
  }
  
}