import java.util.ArrayList;

public class Mode3Thread3ForBoxes implements Runnable {
    IModesValidate validate=new Validation();
    private final String path = "test.csv";
    SudokuGrid gridLoader = new SudokuGrid(path);
    int[][] grid = gridLoader.loadFile(path);
    private boolean anyError=false;
    ArrayList<String> Message= new ArrayList<>();

    @Override
    public void run(){
        checkBoxes();
    }

    private void checkBoxes(){
        for (int i = 1; i <= 9; i++) {
            int[] box = gridLoader.getBox(grid, i);
            ArrayList<Integer> duplicate = validate.checkUnit(box);

            if (!duplicate.isEmpty()) {
                anyError=true;
                for (int d : duplicate) {

                    String s="BOX " + i + ", #" + d + ", " + FormatArray.formatArray(box);
                    Message.add(s);
                }
                Message.add("-------------------------\n");

            }

        }

    }

    public boolean foundAnyError() {
        return anyError;
    }
    public ArrayList<String> getMessage() {
        return Message;
    }
}
