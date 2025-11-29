/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Malak Bahy
 */
import java.util.ArrayList;
public class Mode27ForBoxes implements Runnable{
    
    IModesValidate validate = new Validation();
    private final String path = "C:/Users/Malak Bahy/Documents/NetBeansProjects/ValidSudokuGame-main/src/test.csv";
    SudokuGrid gridLoader = new SudokuGrid(path);
    int[][] grid = gridLoader.loadFile(path);

    private boolean anyError = false;
    ArrayList<String> Message = new ArrayList<>();

    private final int boxNumber; // 1 → 9

    public Mode27ForBoxes(int boxNumber) {
        this.boxNumber = boxNumber;
    }

    @Override
    public void run() {
        checkBox();
    }

    private void checkBox() {

        int[] box = gridLoader.getBox(grid, boxNumber);
        ArrayList<Integer> duplicates = validate.checkUnit(box);

        if (!duplicates.isEmpty()) {
            anyError = true;

            for (int d : duplicates) {
                String s = "BOX " + boxNumber + ", #" + d + ", " + FormatArray.formatArray(box);
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
