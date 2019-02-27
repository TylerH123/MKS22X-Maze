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
    makeIntoMaze(f,rows,cols,maze);
  }
  public void makeIntoMaze(File f, int lines, int linesLength, char[][] arr){
    String str = ""; 
    while(f.hasNextLine()){
      linesLength = f.NextLine().length();
    }

  }
  public boolean checkState(){
    return true;
  }
}
