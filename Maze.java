import java.util.*;
import java.io.*;
public class Maze{

  private char[][] maze;
  private boolean animate;
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
    String m = "";
    int start = 0;
    int end = 0;
    //obtaining amount of lines and characters per line
    //also copying file into a string
    while (file.hasNextLine()){
      String s = file.nextLine();
      rows++;
      cols = s.length();
      m += s + "\n";
    }
    //reset the scanner
    file = new Scanner(f);
    //find out how many starts and ends there are
    for(int i = 0; i < m.length(); i++){
      if (m.charAt(i) == 'S') start++;
      if (m.charAt(i) == 'E') end++;
    }
    if (start > 1) throw new IllegalStateException("There can only be 1 starting point");
    if (start == 0 || end == 0) throw new IllegalStateException("Please make sure there is a start and end point");
    if (end > 1) throw new IllegalStateException("There can only be 1 end point");
    maze = new char[rows][cols];
    copyToArray(m,cols);
  }
  //copies the string version of the maze to the array
  //m is the maze
  //length is the lenght of each line
  public void copyToArray(String m, int length){
    for(int i = 0; i < m.length(); i++){
      int r = 0;
      int c = 0;
      if (m.charAt(i) == '\n'){
        r++;
      }
      if (c >= length - 1){
        c = 0;
      }
      else{
        maze[r][c] = m.charAt(i);
        c++;
      }
    }
  }
  public boolean checkState(){
    return true;
  }
}
