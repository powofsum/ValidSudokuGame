import java.util.ArrayList;

public class Mode0 {

    public static void main(String[] args) throws Exception {

        String path = "C:\\Users\\Yasser Elshaer\\Desktop\\test.csv";

        SudokuGrid gridLoader = new SudokuGrid(path);
        Validation validation = new Validation();
        int[][] grid = gridLoader.loadFile(path);

        boolean anyError = false;

        // ----- Rows -----
        System.out.println("ROWS");
        for (int i = 1; i <= 9; i++) {

            int[] row = gridLoader.getRow(grid, i);
            ArrayList<Integer> duplicate = validation.checkUnit(row);

            if (!duplicate.isEmpty()) {
                anyError = true;

                for (int d : duplicate) {
                    System.out.println("ROW " + i + ", #" + d + ", " + formatArray(row));
            }
        }}
        System.out.println("-------------------------\n");

        // ----- Columns -----
        System.out.println("COLs");
        for (int i = 1; i <= 9; i++) {
            int[] col = gridLoader.getColumn(grid, i);
            ArrayList<Integer> duplicate = validation.checkUnit(col);

            if (!duplicate.isEmpty()) {
                anyError = true;

                for (int d : duplicate) {
                    System.out.println("COL " + i + ", #" + d + ", " + formatArray(col));
            }
        }}
        System.out.println("-------------------------\n");

        // ----- Boxes -----
        System.out.println("BOXs");
        for (int i = 1; i <= 9; i++) {
            int[] box = gridLoader.getBox(grid, i);
            ArrayList<Integer> duplicate = validation.checkUnit(box);

            if (!duplicate.isEmpty()) {
                anyError = true;

                for (int d : duplicate) {
                    System.out.println("BOX " + i + ", #" + d + ", " + formatArray(box));
            }
        }}
        System.out.println("-------------------------\n");

        // ----- Final Result -----
        if (!anyError)
            System.out.println("Sudoku Solution is VALID ");
        else
            System.out.println("Sudoku Solution is INVALID ");
    }

    private static String formatArray(int[] arr) {
        String s = "[";
        
        for (int i = 0; i < arr.length; i++) {
            s+=arr[i];
            if (i <arr.length - 1) s+=", ";
        }
        
        return s+"]";
    }
}
