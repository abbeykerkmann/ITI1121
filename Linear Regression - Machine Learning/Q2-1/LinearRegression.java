//Abbey Kerkmann, 300007054, Section B
//Ryan Matte, 300027432, Section B

/**
 * The class  <b>LinearRegression</b> implements gradient
 * descent for multiple variables
 *
 * @author gvj (gvj@eecs.uottawa.ca)
 *
 */

public class LinearRegression{
  
  /** 
   * Number of features (usually "n" in litterature) 
   */
  private int nbreOfFeatures;
  
  /** 
   * Number of samples (usually "m" in litterature) 
   */
  private int nbreOfSamples;
  
  
  /** 
   * the nbreOfFeatures X nbreOfSamples Matrix of samples
   */
  private double[][] samplesMatrix;
  
  /** 
   * the nbreOfSamples Matrix of samples target values
   */
  private double[] samplesValues;
  
  /** 
   * the nbreOfFeatures Matrix theta of current hypthesis function
   */
  private double[] theta;
  
  
  /** 
   * number of samples received so far
   */
  private int currentNbreOfSamples;
  
  /** 
   * a place holder for theta during descent calculation
   */
  private double[] tempTheta;
  
  
  /** 
   * counts how many iterations have been performed
   */
  private int iteration;
  
  
  /** 
   * Object's contructor. The constructor initializes the instance
   * variables. The starting hypthesis is theta[i]=0.0 for all i
   * 
   * @param n the number of features that we will have
   * @param m the number of samples that we will have
   *
   */
  public LinearRegression(int n, int m){
    nbreOfFeatures = n + 1;
    nbreOfSamples = m;
    samplesValues = new double[nbreOfSamples];
    samplesMatrix = new double[nbreOfSamples][nbreOfFeatures];
    theta = new double[nbreOfFeatures];
    tempTheta = new double[nbreOfFeatures];
    for(int i = 0; i < theta.length; i++) {
      theta[i] = 0.0;
    }
  }
  
  /** 
   * Add a new sample to samplesMatrix and samplesValues
   * 
   * @param x the vectors of samples
   * @param y the coresponding expected value
   *
   */
  public void addSample(double[] x, double y){
    samplesMatrix[currentNbreOfSamples] = x;
    samplesValues[currentNbreOfSamples] = y;
    currentNbreOfSamples++;
  }
  
  /** 
   * Returns the current hypothesis for the value of the input
   * @param x the input vector for which we want the current hypothesis
   * 
   * @return h(x)
   */
  
  private double hypothesis(double[] x) {
    double hypothesis = 0.0;
    for(int i = 0; i < nbreOfFeatures; i++) {
      hypothesis += theta[i] * x[0];
    }
    return hypothesis;
  }
  
  /** 
   * Returns a string representation of hypthesis function
   * 
   * @return the string "theta0 x_0 + theta1 x_1 + .. thetan x_n"
   */
  
  public String currentHypothesis(){
    String result = (Double.toString(theta[0]) + " + ");
    for(int i = 1; i < theta.length - 1; i++) {
      result += (theta[i] + "x_" + i + " + ");
    }
    result += (theta[theta.length - 1] + "x_" + (theta.length - 1));
    return result;
  }
  
  /** 
   * Returns the current cost
   * 
   * @return the current value of the cost function
   */
  
  public double currentCost(){
    double result = 0.0;
    for(int i = 0; i < nbreOfSamples; i++) {
      result += Math.pow(hypothesis(samplesMatrix[i]) - samplesValues[i], 2);
    }
    result = result * (1.0 / nbreOfSamples);
    return result;
  }
  
  /** 
   * runs several iterations of the gradient descent algorithm
   * 
   * @param alpha the learning rate
   *
   * @param numberOfSteps how many iteration of the algorithm to run
   */
  
  public void gradientDescent(double alpha, int numberOfSteps) {
    for(int l = 0; l < numberOfSteps; l++) {
      for(int i = 0; i < nbreOfFeatures; i++) {
        double sum = 0.0;
        for(int j = 0; j < nbreOfSamples; j++) {
          sum += ((hypothesis(samplesMatrix[j]) - samplesValues[j]) * samplesMatrix[j][i]);
        }
        theta[i] = theta[i] - ((alpha * 2.0 / nbreOfSamples) * sum);
      }
      iteration++;
    }
  }
  
  
  /** 
   * Getter for theta
   *
   * @return theta
   */
  
  public double[] getTheta(){
    return theta;
  }
  
  /** 
   * Getter for iteration
   *
   * @return iteration
   */
  
  public int getIteration(){
    return iteration;
  }
}