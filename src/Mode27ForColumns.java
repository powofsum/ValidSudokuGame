import java.util.ArrayList;
public class Mode27ForColumns implements Runnable{

    IModesValidate validate = new Validation();
    private final String path = "C:/Users/Malak Bahy/Documents/NetBeansProjects/ValidSudokuGame-main/src/test.csv";
    SudokuGrid gridLoader = new SudokuGrid(path);
    int[][] grid = gridLoader.loadFile(path);

    private boolean anyError = false;
    ArrayList<String> Message = new ArrayList<>();

    private final int colNo; 

    public Mode27ForColumns(int colNo) {
        this.colNo = colNo;
    }

    @Override
    public void run() {
        checkColumn();
    }

    private void checkColumn() {

        int[] col = gridLoader.getColumn(grid, colNo);
        ArrayList<Integer> duplicates = validate.checkUnit(col);

        if (!duplicates.isEmpty()) {
            anyError = true;

            for (int d : duplicates) {
                String s = "COL " + colNo + ", #" + d + ", " + FormatArray.formatArray(col);
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

    public ArrayList<String> getMessage() {
        return Message;
    }
}
