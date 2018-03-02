//Abbey Kerkmann, 300007054, Section B
//Ryan Matte, 300027432, Section B

/**
 * The class  <b>Assignment</b> is used to
 * test our LinearRegression class. It uses the
 * provided class <b>Display</b> to show the results
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
     * In this second method, we will select a line at random.
     *  1) we select a line y = ax + b, with a randomly selected
     * between -100 and +100 and b randomly selected between 
     * -250 and +250
     *  2) we add 500 samples randomly selected on the line
     * between -100 and +300. For each sample we add a "noise" 
     * randomly selected between -1000 and +1000 (that is, for
     * each randomly selected x, we add the sample (x, ax+b+noise).
     * where "noise" is randomly selected between -1000 and 1000
     *  3) We create an instance of Display
     *  4) we iterate gradient descent (find a number of iterations,
     * a number of updates to the instance of Display, and a 
     * step alpha that seems to work
     */
 private static void randomLine(){
   LinearRegression linear = new LinearRegression(500);
   int a = generator.nextInt(100) - 100;
   int b = generator.nextInt(250) - 250;
   for(int i = 0; i < 500; i++) {
     int x = generator.nextInt(300) - 100;
     int y = (a * x) + b + (generator.nextInt(1000) - 1000);
     linear.addSample(x, y);
   }
   Display display = new Display(linear);
   for(int i = 0; i < 100; i++) {
     linear.gradientDescent(0.000000003, 1000);
     display.update();     
     System.out.println(linear.currentHypothesis());
     System.out.println(linear.currentCost());
   }
 }


 public static void main(String[] args) {

     StudentInfo.display();

  System.out.println("randomLine");
  randomLine();

 }

}