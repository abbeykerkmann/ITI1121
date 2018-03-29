//Abbey Kerkmann, 300007054, Section B
//Ryan Matte, 300027432, Section B

public class Cube {
  public enum Color {
    BLUE, GREEN, RED, WHITE
  }
  
  private int orientation;
  private Cube original;
  private Color[] faces = new Color[6];
  
  /*
   * Constructor for Cube
   * Creates a cube object with an array of colors
   * */
  public Cube(Color[] faces){
    for(int i = 0; i < faces.length; i++)
      this.faces[i] = faces[i];
    orientation = 0;
    original = new Cube(this);
  }
  
  /*
   * Constructor for Cube
   * Creates a cube object with a pre existing cube object
   * */
  public Cube(Cube other) {
    for(int i = 0; i < faces.length; i++)
      this.faces[i] = other.faces[i];
    orientation = 0;
  }
  
  /*
   * Method getUp()
   * Getter for color on up side of cube
   * returns a Color
   * */
  public Color getUp(){
    return faces[0];
  }
  
  /*
   * Method getFront()
   * Getter for color on front side of cube
   * returns a Color
   * */
  public Color getFront(){
    return faces[1];
  }
  
  /*
   * Method getRight()
   * Getter for color on right side of cube
   * returns a Color
   * */
  public Color getRight() {
    return faces[2];
  }
  
  /*
   * Method getBack()
   * Getter for color on back side of cube
   * returns a Color
   * */
  public Color getBack() {
    return faces[3];
  }
  
  /*
   * Method getLeft()
   * Getter for color on left side of cube
   * returns a Color
   * */
  public Color getLeft() {
    return faces[4];
  }
  
  /*
   * Method getDown()
   * Getter for color on down side of cube
   * returns a Color
   * */
  public Color getDown() {
    return faces[5];
  }
  
  /*
   * Method toString()
   * returns a string representation of a Cube
   * */
  public String toString() {
    return "[" + faces[0] + ", " + faces[1] + ", " + faces[2] + ", " + faces[3] + ", " + faces[4] + ", " + faces[5] + "]";
  }
  
  /*
   * Method hasNext()
   * returns a boolean value representing if the cube has more orientations available
   * */
  public Boolean hasNext() {
    if(orientation == 24)
      return false;
    return true;
  }
  
  /*
   * Method next()
   * changes the cube to its next orientation
   * */
  public void next() {
    if(!hasNext())
      throw new IllegalStateException("No next orientation possible");
    switch(orientation) {
      case 0://identify
        orientation++;
        break;
      case 1://all of these are rotate
      case 2:
      case 3:
      case 5:
      case 6:
      case 7:
      case 9:
      case 10:
      case 11:
      case 13:
      case 14:
      case 15:
      case 17:
      case 18:
      case 19:
      case 21:
      case 22:
      case 23:
        rotate();
        break;
      case 4: //rightRoll
      case 8:
      case 20:
        rightRoll();
        break;
      case 12://leftRoll
      case 16:
        leftRoll();
        break;
    }
  }
  
  /*
   * Method copy()
   * returns a deep copy of a cube
   * */
  public Cube copy() {
    Cube result = new Cube(new Color[]{this.getUp(), this.getFront(), this.getRight(), this.getBack(), this.getLeft(), this.getDown()});
    return result;
  }
  
  /*
   * Method rotate()
   * rotates the cube to the right around the top bottom axis
   * */
  private void rotate() {
    Color temp = getLeft();
    faces[4] = faces[3];
    faces[3] = faces[2];
    faces[2] = faces[1];
    faces[1] = temp;
    orientation++;
  }
  
  /*
   * Method rightRoll()
   * rolls the cube to the right around the front back axis
   * */
  private void rightRoll() {
    Color temp = getLeft();
    faces[4] = faces[5];
    faces[5] = faces[2];
    faces[2] = faces[0];
    faces[0] = temp;
    orientation++;
  }
  
  /*
   * Method rightRoll()
   * rolls the cube to the left around the front back axis
   * */
  private void leftRoll() {
    Color temp = getRight();
    faces[2] = faces[5];
    faces[5] = faces[4];
    faces[4] = faces[0];
    faces[0] = temp;
    orientation++;
  }
  
  /*
   * Method reste()
   * restes the cube to the original position
   * */
  public void reset() {
    for(int i = 0; i < faces.length; i++)
      this.faces[i] = original.faces[i];
    orientation = 0;
  }
}