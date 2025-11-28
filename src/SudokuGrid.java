import java.io.BufferedReader;
import java.io.FileReader;

public class SudokuGrid {

  private String csvPath;

  public SudokuGrid(String path){
       csvPath = path;
  }

  public String getCsvPath(){
       return csvPath;
  }
  public int [][] loadFile(String path) throws Exception {
       int Grid[][] = new int[9][9];
       BufferedReader buffer = new BufferedReader(new FileReader(path));
       for (int r = 0; r < 9; r++){
           String line = buffer.readLine();
           
           String parts[] = line.split(",");

           for (int c = 0; c < 9; c++) {
               Grid[r][c] = Integer.parseInt(parts[c]);
           }
       }

       buffer.close();
       return Grid;
  }

  public int [] getRow(int[][] Grid, int r){
       r = r - 1; // to deal with it as an index
       int row[] = new int[9];

       for(int c = 0; c < 9; c++){
          row[c] = Grid[r][c]; // r hena constant , c bt iterates
       }
       return row;
  }

  public int [] getColumn(int[][] Grid, int c){
       c = c - 1; // to deal with it as an index
       int col[] = new int[9];

       for(int r = 0; r < 9; r++){
          col[r] = Grid[r][c]; // c hena constant , r bt iterates
       }
       return col;
  }

  public int[] getBox(int[][] Grid, int b){
       int row = (b - 1) / 3;
       int col = (b - 1) % 3;
       int startRow = row * 3;
       int startCol = col * 3;

       int [] box = new int[9];
       int i = 0;

       for(int r = startRow; r < startRow + 3; r++){
           for(int c = startCol; c < startCol + 3; c++){
               box[i] = Grid[r][c];
               i++;
           }
       }
       return box;
  }

}