import java.util.ArrayList;

public class Mode3Thread2ForColumns implements Runnable{


    private final String path = "test.csv";
    IModesValidate validate=new Validation();
    SudokuGrid gridLoader = new SudokuGrid(path);
    int[][] grid = gridLoader.loadFile(path);
    private  boolean anyError=false;
    ArrayList<String> Message= new ArrayList<>();



    @Override
    public void run(){
        checkColumns();
    }

    private void checkColumns(){
        for (int i = 1; i <= 9; i++) {
            int[] col = gridLoader.getColumn(grid, i);
            ArrayList<Integer> duplicate = validate.checkUnit(col);
            if (!duplicate.isEmpty()) {
                anyError=true;
                for (int d : duplicate) {

                    String s="COl " + i + ", #" + d + ", " + FormatArray.formatArray(col);
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
