/*
 * MazeSolver.java
 *
 * UVic CSC 115, Spring 2017
 *
 * Purpose:
 *   class that contains a single public static method called
 *   "findPath". To involve the method one must have already created
 *   an instance of Maze. The method must return a path through the
 *   maze (if it exists) in the format shown within the Assignment #3
 *   description.
 *
 * Note: You are free to add to this class whatever other methods will
 * help you in writing a solution to A#3 part 2.
 */

 /*
* Name: Gareth Marriott
* ID: V00875748
* Date: Febuary 28
* Filename: MazeSolver.java
* Details: CSC115 Assignment 3
*/

public class MazeSolver {
  public static long totalTime = 0;
    public static String findPath(Maze maze) {
        String result;
        long STARTTIME = System.currentTimeMillis();

        result = stackSolve(maze);

        long ENDTIME = System.currentTimeMillis();
        totalTime = totalTime +(ENDTIME - STARTTIME);
        //System.out.println(path);
        return result;
    }

    public static void wallChecker(boolean[][] visited , MazeLocation cur , Maze maze){

      //Checking if Wall is to the left of current position
      //if true marks as visited
      if (maze.isWall(cur.getRow() , cur.getCol()-1)) {
        visited[cur.getRow()][cur.getCol()-1] = true;
      }

      //Checking if Wall is to the below of current position
      if (maze.isWall(cur.getRow()-1 , cur.getCol())) {
        visited[cur.getRow()-1][cur.getCol()] = true;
      }

      //Checking if Wall is to the right of current position
      if (maze.isWall(cur.getRow() , cur.getCol()+1)) {
        visited[cur.getRow()][cur.getCol()+1] = true;
      }

      //Checking if Wall is to the above of current position
      if (maze.isWall(cur.getRow()+1 , cur.getCol())) {
        visited[cur.getRow()+1][cur.getCol()] = true;
      }
    }


    /*  boolean[][]: Passes boolean array to update the current location as visited
      MazeLocation : passes current MazeLocation and
        @returns with the next step in maze
        OR if no path suitible step back (Pop stack)
      Stack<MazeLocation>: Used to push() new places visited onto stack
                          OR pop() if no path suitible                              */
    public static MazeLocation advance(boolean[][] visited , MazeLocation cur , Stack<MazeLocation> path) throws StackEmptyException{

      //Advance in maze (Checking place to the left is not visited)
      if (!(visited[cur.getRow()][cur.getCol()-1])) {
        //Push the unvisited path onto the stack
        path.push(new MazeLocation(cur.getRow() , cur.getCol()-1));
        //update the visited array with the new chosen path
        visited[cur.getRow()][cur.getCol()] = true;
        //update currentlocation with the chosen path
        cur = new MazeLocation(cur.getRow() , cur.getCol()-1);
      }

      else if (!(visited[cur.getRow()-1][cur.getCol()])) {
        path.push(new MazeLocation(cur.getRow()-1 , cur.getCol()));
        visited[cur.getRow()][cur.getCol()] = true;
        cur = new MazeLocation(cur.getRow()-1 , cur.getCol());
      }

      else if (!(visited[cur.getRow()+1][cur.getCol()])) {
        path.push(new MazeLocation(cur.getRow()+1 , cur.getCol()));
        visited[cur.getRow()][cur.getCol()] = true;
        cur = new MazeLocation(cur.getRow()+1 , cur.getCol());
      }

      else if (!(visited[cur.getRow()][cur.getCol()+1])) {
        path.push(new MazeLocation(cur.getRow() , cur.getCol()+1));
        visited[cur.getRow()][cur.getCol()] = true;
        cur = new MazeLocation(cur.getRow() , cur.getCol()+1);
      }

      else {
        //Mark currentlocation as visited and pop() the stack back one step
        //Setting the currentlocation to the new top of the stack
        visited[cur.getRow()][cur.getCol()] = true;
        path.pop();
        cur = path.peek();
      }
      return cur;
    }

    public static String stackSolve(Maze maze){
      MazeLocation entry      = maze.getEntry();
      MazeLocation exit       = maze.getExit();
      MazeLocation cur = new MazeLocation(entry.getRow() +1 , entry.getCol());

      Stack<MazeLocation> path = new StackRefBased<MazeLocation>();
      boolean[][] visited = new boolean[maze.getNumRows()][maze.getNumCols()];

      //push() entry and location directly below and marks the entry as visited
      //Starts the path finder from one below the entry
      path.push(entry);
      path.push(cur);
      visited[entry.getRow()][entry.getCol()] = true;

      //Loops until currentlocation is equal to the exit location
      while (!(cur.toString().equals(exit.toString()))) {
        try {
          wallChecker(visited , cur , maze);
          cur = advance(visited , cur , path);
          if (cur.getRow()==0) {
            return "";
          }
        }catch (Exception e) {
          //Should never throw
          e.printStackTrace();
          System.exit(1);
        }
      }
      return path.toString();
    }




    public static void main(String[] args) {
      String  testDir = "tests/";
      Maze maze;
      String path;

      maze = new Maze(testDir + "maze00.txt");
      path = MazeSolver.findPath(maze);
      displayResults(path.equals("(0,1) (1,1) (2,1)"));

      maze = new Maze(testDir + "maze01.txt");
      path = MazeSolver.findPath(maze);
      displayResults(path.equals(
          "(0,1) (1,1) (1,2) (1,3) (1,4) (1,5) (1,6) (2,6)"
      ));

      maze = new Maze(testDir + "maze02.txt");
      path = MazeSolver.findPath(maze);
      displayResults(path.equals(
          "(0,1) (1,1) (2,1) (3,1) (3,2) (3,3) (3,4) (3,5) "
        + "(3,6) (4,6)"
      ));

      maze = new Maze(testDir + "maze03.txt");
      path = MazeSolver.findPath(maze);
      displayResults(path.equals(""));

      maze = new Maze(testDir + "maze04.txt");
      path = MazeSolver.findPath(maze);
      displayResults(path.equals(""));

      maze = new Maze(testDir + "maze05.txt");
      path = MazeSolver.findPath(maze);
      displayResults(path.equals(""));

      maze = new Maze(testDir + "maze06.txt");
      path = MazeSolver.findPath(maze);
      displayResults(path.equals(
          "(0,1) (1,1) (1,2) (1,3) (1,4) (1,5) (2,5) "
        + "(3,5) (3,6) (3,7) (4,7) (5,7) (5,8) (5,9) "
        + "(6,9) (7,9) (8,9)"
      ));

      maze = new Maze(testDir + "maze07.txt");
      path = MazeSolver.findPath(maze);
      displayResults(path.equals(
          "(0,1) (1,1) (1,2) (1,3) (1,4) (1,5) (1,6) "
        + "(1,7) (1,8) (1,9) (1,10) (1,11) (1,12) (1,13) "
        + "(2,13) (3,13) (4,13) (5,13) (6,13) (7,13) (8,13) "
        + "(9,13) (10,13) (11,13) (12,13) (13,13) (14,13)"
      ));

      maze = new Maze(testDir + "maze08.txt");
      path = MazeSolver.findPath(maze);
      displayResults(path.equals(
            "(0,1) (1,1) (2,1) (3,1) (4,1) (5,1) "
          + "(6,1) (7,1) (8,1) (9,1) (10,1) (11,1) "
          + "(11,2) (11,3) (12,3) (13,3) (13,4) "
          + "(13,5) (14,5) (15,5) (16,5) (17,5) "
          + "(17,4) (17,3) (17,2) (17,1) (18,1) "
          + "(19,1) (19,2) (19,3) (19,4) (19,5) "
          + "(19,6) (19,7) (18,7) (17,7) (17,8) "
          + "(17,9) (18,9) (19,9) (19,10) (19,11) "
          + "(19,12) (19,13) (18,13) (17,13) (17,12) "
          + "(17,11) (16,11) (15,11) (14,11) (13,11) "
          + "(13,10) (13,9) (14,9) (15,9) (15,8) "
          + "(15,7) (14,7) (13,7) (12,7) (11,7) "
          + "(10,7) (9,7) (9,8) (9,9) (8,9) (7,9) "
          + "(7,8) (7,7) (6,7) (5,7) (5,8) (5,9) "
          + "(5,10) (5,11) (6,11) (7,11) (8,11) "
          + "(9,11) (10,11) (11,11) (11,12) (11,13) "
          + "(11,14) (11,15) (11,16) (11,17) (12,17) "
          + "(13,17) (14,17) (15,17) (15,18) (15,19) "
          + "(16,19) (17,19) (17,18) (17,17) (17,16) "
          + "(17,15) (18,15) (19,15) (19,16) (19,17) "
          + "(19,18) (19,19) (20,19)"
      ));

      maze = new Maze(testDir + "maze09.txt");
      path = MazeSolver.findPath(maze);
      displayResults(path.equals(
          "(0,1) (1,1) (1,2) (1,3) (1,4) (1,5) "
          + "(1,6) (1,7) (1,8) (1,9) (2,9) (3,9) "
          + "(3,8) (3,7) (3,6) (3,5) (4,5) (5,5) "
          + "(5,6) (5,7) (5,8) (5,9) (5,10) (5,11) "
          + "(4,11) (3,11) (3,12) (3,13) (3,14) "
          + "(3,15) (2,15) (1,15) (1,16) (1,17) "
          + "(2,17) (3,17) (3,18) (3,19) (4,19) "
          + "(5,19) (5,20) (5,21) (5,22) (5,23) "
          + "(6,23) (7,23) (8,23) (9,23) (10,23) "
          + "(11,23) (12,23) (13,23) (13,24) (13,25) "
          + "(12,25) (11,25) (11,26) (11,27) (10,27) "
          + "(9,27) (9,28) (9,29) (10,29) (11,29) "
          + "(12,29) (13,29) (14,29) (15,29) (16,29) "
          + "(17,29) (17,28) (17,27) (18,27) (19,27) "
          + "(19,28) (19,29) (20,29) (21,29) (21,28) "
          + "(21,27) (22,27) (23,27) (23,26) (23,25) "
          + "(24,25) (25,25) (25,26) (25,27) (26,27) "
          + "(27,27) (28,27) (29,27) (29,28) (29,29) "
          + "(30,29)"
      ));

      maze = new Maze(testDir + "maze10.txt");
      path = MazeSolver.findPath(maze);
      displayResults(path.equals(
          "(0,1) (1,1) (1,2) (1,3) (2,3) (3,3) "
          + "(3,4) (3,5) (4,5) (5,5) (5,4) (5,3) "
          + "(5,2) (5,1) (6,1) (7,1) (7,2) (7,3) "
          + "(8,3) (9,3) (10,3) (11,3) (12,3) (13,3) "
          + "(13,2) (13,1) (14,1) (15,1) (16,1) "
          + "(17,1) (18,1) (19,1) (20,1) (21,1) "
          + "(22,1) (23,1) (24,1) (25,1) (26,1) "
          + "(27,1) (28,1) (29,1) (29,2) (29,3) "
          + "(30,3) (31,3) (32,3) (33,3) (33,2) "
          + "(33,1) (34,1) (35,1) (35,2) (35,3) "
          + "(35,4) (35,5) (34,5) (33,5) (33,6) "
          + "(33,7) (33,8) (33,9) (33,10) (33,11) "
          + "(34,11) (35,11) (35,10) (35,9) (35,8) "
          + "(35,7) (36,7) (37,7) (37,8) (37,9) "
          + "(37,10) (37,11) (37,12) (37,13) (37,14) "
          + "(37,15) (37,16) (37,17) (37,18) (37,19) "
          + "(38,19) (39,19) (39,20) (39,21) (38,21) "
          + "(37,21) (37,22) (37,23) (36,23) (35,23) "
          + "(35,24) (35,25) (35,26) (35,27) (36,27) "
          + "(37,27) (37,28) (37,29) (38,29) (39,29) "
          + "(39,30) (39,31) (39,32) (39,33) (39,34) "
          + "(39,35) (38,35) (37,35) (37,36) (37,37) "
          + "(38,37) (39,37) (39,38) (39,39) (40,39)"
      ));

      System.out.println("testMazeSolver: end");
      System.out.println(totalTime);
    }
    public static void displayResults (boolean passed)
  {
        if (!(passed)) {
            System.exit(1);
        }
  }

}
