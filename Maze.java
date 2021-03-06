import java.util.*;
import java.io.*;
public class Maze{

  private char[][] maze;
  private boolean animate;
  private int[] direction = new int[]{0, -1, 0, 1, 1, 0, -1, 0};
  private int startRow, startCol, endRow, endCol;
  /*Constructor loads a maze text file, and sets animate to false by default.

      1. The file contains a rectangular ascii maze, made with the following 4 characters:
      '#' - Walls - locations that cannot be moved onto
      ' ' - Empty Space - locations that can be moved onto
      'E' - the location of the goal (exactly 1 per file)
      'S' - the location of the start(exactly 1 per file)

      2. The maze has a border of '#' around the edges. So you don't have to check for out of bounds!

      3. When the file is not found OR the file is invalid (not exactly 1 E and 1 S) then:
         throw a FileNotFoundException or IllegalStateException
  */
  public Maze(String filename) throws FileNotFoundException{
    animate = false;
    File f = new File(filename);
    Scanner file = new Scanner(f);
    int rows = 0;
    int cols = 0;
    //count of how many start points
    int start = 0;
    //count of how many end points
    int end = 0;
    //obtaining amount of lines and characters per line
    //also copying file into a string for easier access
    while (file.hasNextLine()){
      String s = file.nextLine();
      rows++;
      cols = s.length();
    }
    //reset the scanner
    file = new Scanner(f);
    maze = new char[rows][cols];
    //find out how many starts and ends there are
    //also find out where starting and end point are
    for(int i = 0; i < rows; i++){
      String line = file.nextLine();
      for (int j = 0; j < cols; j++){
        char c = line.charAt(j);
        if (c == 'S'){
          start++;
          startRow = i;
          startCol = j;
        }
        if (c == 'E'){
          end++;
          endRow = i;
          endCol = j;
        }
        maze[i][j] = c;
      }
    }
    if (start > 1 || end > 1) throw new IllegalStateException("There can only be 1 starting point or ending point");
    if (start == 0 || end == 0) throw new IllegalStateException("Please make sure there is a start and end point");
  }
  //copies the string version of the maze to the array
  //m is the maze
  //length is the lenght of each line
  //size is the amount of rows
  public void copyToArray(String m, int size, int length){
    int r = 0;
    int c = 0;
    for(int i = 0; i < m.length(); i++){
      if (r < size){
        if (m.charAt(i) == '\n'){
          r++;
        }
        if (c >= length){
          c = 0;
        }
        else{
          maze[r][c] = m.charAt(i);
          c++;
        }
      }
    }
  }
  private void wait(int millis){
    try {
      Thread.sleep(millis);
    }
    catch (InterruptedException e) {
    }
  }
  public void setAnimate(boolean b){
    animate = b;
  }
  public void clearTerminal(){
        //erase terminal, go to top left of screen.
        System.out.println("\033[2J\033[1;1H");
  }
  /*Return the string that represents the maze.
     It should look like the text file with some characters replaced.
  */
  public String toString(){
    String output = "";
    for (int r = 0; r < maze.length; r++){
      for (int c = 0; c < maze[r].length; c++){
        output += maze[r][c];
      }
      output += "\n";
    }
    return output;
  }
  /*Wrapper Solve Function returns the helper function
     Note the helper function has the same name, but different parameters.
     Since the constructor exits when the file is not found or is missing an E or S, we can assume it exists.
  */
  public int solve(){
    maze[startRow][startCol] = ' ';
    //start solving at the location of the s.
    return solve(startRow,startCol,0);
  }
  /*
     Recursive Solve function:

     A solved maze has a path marked with '@' from S to E.

     Returns the number of @ symbols from S to E when the maze is solved,
     Returns -1 when the maze has no solution.

     Postcondition:
       The S is replaced with '@' but the 'E' is not.
       All visited spots that were not part of the solution are changed to '.'
       All visited spots that are part of the solution are changed to '@'
  */
  private int solve(int row, int col, int count){
    //automatic animation! You are welcome.
    if(animate){
      clearTerminal();
      System.out.println(this);
      wait(10);
    }
    //if end is reached
    if (maze[row][col] == 'E'){
      return count;
    }
    //if the loc is not an empty spot
    if (maze[row][col] != ' '){
      return -1;
    }
    //loop through each direction
    for (int i = 0; i < direction.length; i+=2){
      //mark the place you are with @
      maze[row][col] = '@';
      int next = solve(row + direction[i],col + direction[i+1],count+1);
      if (next != -1){
        return next;
      }
      //mark the place you been to with a period
      maze[row][col] = '.';
    }
    return -1;
  }
  public static void main(String[] args){
    try{
      //Maze z = new Maze("Maze1.txt");
      //z.setAnimate(true);
      //System.out.println(z);
      //Maze z2 = new Maze("Maze2.txt");
      //System.out.println(z);
      //System.out.println(z.solve());
      Maze f;
      //f = new Maze("data2.dat");
      f = new Maze("Maze1.txt");
      //true animates the maze.
      f.setAnimate(false);
      System.out.println(f.solve());
      //System.out.println(f);
    }
    catch(FileNotFoundException e){
      System.out.println("File not found");
    }
  }
}
