
import javax.swing.*;
import java.util.ArrayList;
public class Mode0 implements ISwitchModes  {

    // public static void main(String[] args)  {

    String path = "test.csv";

    SudokuGrid gridLoader = new SudokuGrid(path);
    Validation validation = new Validation();
    int[][] grid = gridLoader.loadFile(path);
    boolean anyError = false;
    ArrayList<String> Message= new ArrayList<>();
//    public Mode0(){
//        checkRows();
//        checkColumns();
//        checkBoxes();
//    }
    @Override
    public void print(){
        checkRows();
        checkColumns();
        checkBoxes();
    }


    // ----- Rows -----
    // System.out.println("ROWS");

    public void checkRows(){
        for (int i = 1; i <= 9; i++) {

            int[] row = gridLoader.getRow(grid, i);
            ArrayList<Integer> duplicate = validation.checkUnit(row);

            if (!duplicate.isEmpty()) {
                anyError = true;

                for (int d : duplicate) {
                    String s="ROW " + i + ", #" + d + ", " + FormatArray.formatArray(row);
                    Message.add(s);
                }

            }

        }
        if(anyError)
            Message.add("-------------------------\n");
    }


    // ----- Columns -----
    // System.out.println("COLs");
    public void checkColumns(){
        for (int i = 1; i <= 9; i++) {
            int[] col = gridLoader.getColumn(grid, i);
            ArrayList<Integer> duplicate = validation.checkUnit(col);

            if (!duplicate.isEmpty()) {
                anyError = true;

                for (int d : duplicate) {
                    String s="COL " + i + ", #" + d + ", " + FormatArray.formatArray(col);
                    Message.add(s);
                }
            }

        }
        if(anyError)
            Message.add("-------------------------\n");
    }

    // ----- Boxes -----
    //System.out.println("BOXs");
    public void checkBoxes(){
        for (int i = 1; i <= 9; i++) {
            int[] box = gridLoader.getBox(grid, i);
            ArrayList<Integer> duplicate = validation.checkUnit(box);

            if (!duplicate.isEmpty()) {
                anyError = true;

                for (int d : duplicate) {
                    String s="BOX" + i + ", #" + d + ", " + FormatArray.formatArray(box);
                    Message.add(s);
                }
            }

        }
        if(anyError)
        Message.add("-------------------------\n");
    }

@Override
    public boolean foundAnyError() {
        return anyError;
    }
@Override
    public ArrayList<String> getMessage() {
        return Message;
    }
}