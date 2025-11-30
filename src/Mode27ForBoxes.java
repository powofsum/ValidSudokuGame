import java.util.ArrayList;
public class Mode27ForBoxes implements Runnable{
    
    IModesValidate validate = new Validation();
    private final String path = "test.csv";
    SudokuGrid gridLoader = new SudokuGrid(path);
    int[][] grid = gridLoader.loadFile(path);

    private boolean anyError = false;
    ArrayList<String> Message = new ArrayList<>();

    private final int boxNo; 

    public Mode27ForBoxes(int boxNo) {
        this.boxNo = boxNo;
    }

    @Override
    public void run() {
        checkBox();
    }

    private void checkBox() {

        int[] box = gridLoader.getBox(grid, boxNo);
        ArrayList<Integer> duplicates = validate.checkUnit(box);

        if (!duplicates.isEmpty()) {
            anyError = true;

            for (int d : duplicates) {
                String s = "BOX " + boxNo + ", #" + d + ", " + FormatArray.formatArray(box);
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
