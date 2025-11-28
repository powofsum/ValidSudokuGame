import java.util.ArrayList;

public class Mode3Thread1ForRows implements Runnable {
    IModesValidate validate=new Validation();
    private final String path = "test.csv";
    SudokuGrid gridLoader = new SudokuGrid(path);
    int[][] grid = gridLoader.loadFile(path);
    private boolean anyError=false;
    ArrayList<String> Message= new ArrayList<>();


    @Override
    public void run(){
        checkRows();
    }
    private void checkRows(){
        for (int i = 1; i <= 9; i++) {
            int[] row = gridLoader.getRow(grid, i);
            ArrayList<Integer> duplicate = validate.checkUnit(row);
            if (!duplicate.isEmpty()) {
                anyError=true;
                for (int d : duplicate) {

                    String s="ROW " + i + ", #" + d + ", " + FormatArray.formatArray(row);
                    Message.add(s);
                }
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




