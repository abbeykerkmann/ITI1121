//Abbey Kerkmann, 300007054, Section B
//Ryan Matte, 300027432, Section B

public class Solve {
  static Cube[] cubes = new Cube[]{new Cube(new Cube.Color[]{Cube.Color.BLUE, Cube.Color.GREEN, Cube.Color.WHITE, Cube.Color.GREEN, Cube.Color.BLUE, Cube.Color.RED}),
    new Cube(new Cube.Color[]{Cube.Color.WHITE, Cube.Color.GREEN, Cube.Color.BLUE, Cube.Color.WHITE, Cube.Color.RED, Cube.Color.RED}),
    new Cube(new Cube.Color[]{Cube.Color.GREEN, Cube.Color.WHITE, Cube.Color.RED, Cube.Color.BLUE, Cube.Color.RED, Cube.Color.RED}),
    new Cube(new Cube.Color[]{Cube.Color.BLUE, Cube.Color.RED, Cube.Color.GREEN, Cube.Color.GREEN, Cube.Color.WHITE, Cube.Color.WHITE})};
  
  /*
   * class Method generateAndTest()
   * returns a queue containing valid solutions
   * preconditions: number of cubes in a possible solution ranges from 1 to 4
   * */
  public static Queue<Solution> generateAndTest() {
    Solution sol = new Solution(cubes);
    Queue<Solution> sols = new LinkedQueue<Solution>();
    while(sol.getCube(0).hasNext()) {
      while(sol.getCube(1).hasNext()) {
        while(sol.getCube(2).hasNext()) {
          while(sol.getCube(3).hasNext()) {
            sol.getCube(3).next();
            if(sol.isValid())
              sols.enqueue(sol);
          }
          sol.getCube(2).next();
          if(sol.isValid())
            sols.enqueue(sol);
          sol.getCube(3).reset();
        }
        sol.getCube(1).next();
        if(sol.isValid())
          sols.enqueue(sol);
        sol.getCube(2).reset();
      }
      sol.getCube(0).next();
      if(sol.isValid())
        sols.enqueue(sol);
      sol.getCube(1).reset();
    }
    System.out.println(sol.getNumberOfCalls());
    return sols;
  }
  
  /*
   * class Method breadthFirstSearch()
   * returns a queue containing valid solutions using the breadth first search algorythym
   * preconditions: number of cubes in a possible solution ranges from 1 to 4
   * */
  public static Queue<Solution> breadthFirstSearch() {
    Solution sol = new Solution(new Cube[]{cubes[0]});
    Solution allCubes = new Solution(cubes);
    Queue<Solution> solutions = new LinkedQueue<Solution>();
    Queue<Solution> open = new LinkedQueue<Solution>();
    while(sol.getCube(0).hasNext()) {
      sol.getCube(0).next();
      open.enqueue(sol);
    }
    while(!open.isEmpty()) {
      Solution current = open.dequeue();
      for(int i = 1; i< current.size(); i++) {
        current = new Solution(current, allCubes.getCube(i));
        if(current.isValid()) {
          if(current.size()==4)
            solutions.enqueue(current);
          else
            open.enqueue(current);
        } 
      }
    }
    System.out.println(sol.getNumberOfCalls());
    return solutions;
  }
  
  /*
   * class Method main
   * executes the two class methods
   * */
  public static void main(String[] args) {
    StudentInfo.display();
    long start, stop;
    System.out.println("generateAndTest:");
    start = System.currentTimeMillis();
    generateAndTest();
    stop = System.currentTimeMillis();
    System.out.println("Elapsed time: " + (stop - start) + " milliseconds");
    
    System.out.println("breadthFirstSearch:");
    start = System.currentTimeMillis();
    breadthFirstSearch();
    stop = System.currentTimeMillis();
    System.out.println("Elapsed time: " + (stop - start) + " milliseconds");
  }
}