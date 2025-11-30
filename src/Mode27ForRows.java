import java.util.ArrayList;
public class Mode27ForRows implements Runnable{

    IModesValidate validate = new Validation();
    private final String path = "test.csv";
    SudokuGrid gridLoader = new SudokuGrid(path);
    int[][] grid = gridLoader.loadFile(path);

    private boolean anyError = false;
    ArrayList<String> Message = new ArrayList<>();

    private final int rowNo;

    public Mode27ForRows (int rowNo) {
        this.rowNo = rowNo;
    }

    @Override
    public void run() {
        checkRow();
    }

    private void checkRow() {

        int[] row = gridLoader.getRow(grid, rowNo);
        ArrayList<Integer> duplicates = validate.checkUnit(row);

        if (!duplicates.isEmpty()) {
            anyError = true;

            for (int d : duplicates) {
                String s = "ROW " + rowNo + ", #" + d + ", " + FormatArray.formatArray(row);
                Message.add(s);
            }

//            Message.add("-------------------------\n");
        }
    }

    public boolean foundAnyError() {
        return anyError;
    }

    public ArrayList<String> getMessage() {
        return Message;
    }

}

