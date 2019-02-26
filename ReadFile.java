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
      while(inf.hasNext()){
        boolean next = true;
        if(inf.next() == "\n"){
          next = false;
        }
        if(next){
          wPerL++;
        }
      }
      String[][] maze = new String[lines][wPerL];
      int row = 0;
      int col = 0;
      while(inf.hasNext()){
        String c = inf.next();
        maze[row][col] = c;
        if(col == wPerL - 1){
          row++;
          col = 0;
        }
        col++;
      }
      String output = "";
      for(int i = 0; i < lines; i++){
        for(int j = 0; j < wPerL; j++){
          output += maze[i][j];
        }
      }
      System.out.println(output);
    }
    catch(FileNotFoundException e){
      System.out.println("File not found");
    }
  }

}
