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
      while(inf.hasNextLine()){
        stringInf += inf.nextLine() + "\n";
      }
      //System.out.println(stringInf);
      for(int i = 0; i < stringInf.length(); i++){
        if (stringInf.charAt(i) == '\n'){
          lines++;
        }
      }
      //System.out.println(lines);
      //string vers of first line
      String line1 = "";
      //System.out.println(inf.hasNextLine());
      if (inf.hasNextLine()){
        line1 += inf.nextLine();
      }
      //System.out.println(line1);
      for(int i = 0; i < line1.length(); i++){
        wPerL++;
      }
      //System.out.println(wPerL);
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
