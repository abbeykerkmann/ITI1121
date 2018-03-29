//Abbey Kerkmann, 300007054, Section B
//Ryan Matte, 300027432, Section B

import java.lang.String;

public class Solution {
  private Cube[] cubes = new Cube[4];
  private int count;
  
  public Solution(Cube[] cubes) {
    this.cubes = new Cube[cubes.length];
    for(int i = 0; i < this.cubes.length; i++)
      this.cubes[i] = cubes[i].copy();
    count = 0;
  }
  
  public Solution(Solution other, Cube c) {
    if(c == null)
      throw new NullPointerException("Cube extension cannot be null");
    if(size() == 4)
      throw new IllegalStateException("Cannot be more than 4 cubes in the solution");
    for(int i = 0; i < cubes.length; i++) {
      if(cubes[i] == null) {
        cubes[i] = c.copy();
      }
      else
        cubes[i] = other.cubes[i].copy();
    }
  }
  
  public int size() {
    return cubes.length;
  }
  public Cube getCube(int pos) {
    return cubes[pos];
  }
  public boolean isValid() {
    count++;
    for(int i = 0; i < cubes.length-1; i++) {
      Cube.Color temp = cubes[i].getUp();
      for(int j = i+1; j < cubes.length; j++) {
        if(cubes[j].getUp().equals(temp)) {
          return false;
        }
      }
      temp = cubes[i].getFront();
      for(int j = i+1; j < cubes.length; j++) {
        if(cubes[j].getFront().equals(temp)) {
          return false;
        }
      }
      temp = cubes[i].getRight();
      for(int j = i+1; j < cubes.length; j++) {
        if(cubes[j].getRight().equals(temp)) {
          return false;
        }
      }
      temp = cubes[i].getBack();
      for(int j = i+1; j < cubes.length; j++) {
        if(cubes[j].getBack().equals(temp)) {
          return false;
        }
      }
      temp = cubes[i].getLeft();
      for(int j = i+1; j < cubes.length; j++) {
        if(cubes[j].getLeft().equals(temp)) {
          return false;
        }
      }
      temp = cubes[i].getDown();
      for(int j = i+1; j < cubes.length; j++) {
        if(cubes[j].getDown().equals(temp)) {
          return false;
        }
      }
    }
    return true;
  }
  public boolean isValid(Cube next) {
    count++;
    if(cubes.length == 4)
      return false;
    for(int i = 0; i < cubes.length; i++) {
      if(cubes[i].getUp().equals(next.getUp()))
        return false;
      if(cubes[i].getFront().equals(next.getFront()))
        return false;
      if(cubes[i].getRight().equals(next.getRight()))
        return false;
      if(cubes[i].getBack().equals(next.getBack()))
        return false;
      if(cubes[i].getLeft().equals(next.getLeft()))
        return false;
      if(cubes[i].getDown().equals(next.getDown()))
        return false;
    }
    return true;
  }
  public String toString() {
    String result = "[";
    for(int i = 0; i < cubes.length; i++) {
      result = result + ("[" + cubes[i].getUp() + ", " + cubes[i].getFront() + ", " + cubes[i].getRight() + ", " + cubes[i].getBack() + ", " + cubes[i].getLeft() + ", " + cubes[i].getDown() + "],");
    }
    result = result + "]";
    return result;
  }
  public int getNumberOfCalls() {
    return count;
  }
  public void resetNumberOfCalls() {
    count = 0;
  }
  
  public static void main(String[] args) {
    Cube[] cubes = new Cube[]{new Cube(new Cube.Color[]{Cube.Color.BLUE, Cube.Color.WHITE, Cube.Color.WHITE, Cube.Color.GREEN, Cube.Color.BLUE, Cube.Color.RED}),
    new Cube(new Cube.Color[]{Cube.Color.WHITE, Cube.Color.BLUE, Cube.Color.BLUE, Cube.Color.RED, Cube.Color.RED, Cube.Color.GREEN}),
    new Cube(new Cube.Color[]{Cube.Color.GREEN, Cube.Color.GREEN, Cube.Color.RED, Cube.Color.BLUE, Cube.Color.GREEN, Cube.Color.BLUE}),
    new Cube(new Cube.Color[]{Cube.Color.RED, Cube.Color.RED, Cube.Color.GREEN, Cube.Color.WHITE, Cube.Color.WHITE, Cube.Color.WHITE})};
    Solution sol = new Solution(cubes);
    System.out.println(sol.isValid());
  }
}