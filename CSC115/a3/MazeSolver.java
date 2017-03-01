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

public class MazeSolver {
    public static String findPath(Maze maze) {


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
        //System.out.println(path);
        return path.toString();
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

}
