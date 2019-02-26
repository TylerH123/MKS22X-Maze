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
      //string version of file
      String stringInf = "";
      //boolean to check if it is reading first line
      boolean isFirstLine = true;
      //string vers of first line
      String line1 = "";
      //System.out.println(wPerL);
      while(inf.hasNextLine()){
        String line = inf.nextLine();
        if (isFirstLine){
          line1 += line;
          isFirstLine = false;
        }
        stringInf += line + "\n";
      }
      //System.out.println(stringInf);
      //count # of lines
      for(int i = 0; i < stringInf.length(); i++){
        if (stringInf.charAt(i) == '\n'){
          lines++;
        }
      }
      //System.out.println(lines);
      //System.out.println(inf.hasNextLine());
      //System.out.println(line1);
      //count number of characters in a row
      for(int i = 0; i < line1.length(); i++){
        wPerL++;
      }
      //System.out.println(wPerL);
      //System.out.println(stringInf);
      char[][] maze = new char[lines][wPerL];
      int row = 0;
      int col = 0;
      for(int i = 0; i < stringInf.length(); i++){
        if (row < lines){
          if (col >= wPerL){
            col = 0;
          }
          if (stringInf.charAt(i) == '\n'){
            row++;
          }
          else{
            maze[row][col] = stringInf.charAt(i);
            col++;
          }
        }
      }
      //string representation of array
      String output = "";
      for(int i = 0; i < lines; i++){
        for(int j = 0; j < wPerL; j++){
          output += maze[i][j];
        }
        output += "\n";
      }
      System.out.println(output);
    }
    catch(FileNotFoundException e){
      System.out.println("File not found");
    }
  }

}
