/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Malak Bahy
 */
 import java.util.ArrayList;
public class Mode27ForRows implements Runnable{

    IModesValidate validate = new Validation();
    private final String path = "C:/Users/Malak Bahy/Documents/NetBeansProjects/ValidSudokuGame-main/src/test.csv";
    SudokuGrid gridLoader = new SudokuGrid(path);
    int[][] grid = gridLoader.loadFile(path);

    private boolean anyError = false;
    ArrayList<String> Message = new ArrayList<>();

    private final int rowNumber; 

    public Mode27ForRows (int rowNumber) {
        this.rowNumber = rowNumber;
    }

    @Override
    public void run() {
        checkRow();
    }

    private void checkRow() {

        int[] row = gridLoader.getRow(grid, rowNumber);
        ArrayList<Integer> duplicates = validate.checkUnit(row);

        if (!duplicates.isEmpty()) {
            anyError = true;

            for (int d : duplicates) {
                String s = "ROW " + rowNumber + ", #" + d + ", " + FormatArray.formatArray(row);
                Message.add(s);
            }

            Message.add("-------------------------\n");
        }
    }

    public boolean foundAnyError() {
        return anyError;
    }

    public ArrayList<String> getMessage() {
        return Message;
    }
} 
