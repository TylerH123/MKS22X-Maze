import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class ReadFile{

  public static void main(String[] args){
    try{
      File f = new File("Maze1.txt");
      Scanner inf = new Scanner(f);
      //amt of lines for amt of rows
      int lines = 0;
      //amt of words per line for length of each row
      int wPerL = 0;
      while(inf.hasNextLine()){
        lines++;
      }
      while(inf.next() != "\n"){
        wPerL++;
      }
      String[][] maze = new String[lines][wPerL];
      while(inf.hasNext()){
        int row = 0;
        int col = 0;
        String c = inf.next();
        maze[row][col] = c;
        if(col == wPerL - 1){
          row++;
          col = 0;
        }
      }
      
    }
    catch(FileNotFoundException e){
      System.out.println("File not found");
    }
  }

}
