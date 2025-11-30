import java.util.Scanner;
import static java.lang.System.exit;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        Scanner scanner = new Scanner(System.in);
//        boolean foundMode =false;
        ISwitchModes chooseMode=null;

        System.out.println("Enter mode (0,3,27):");
        int mode = scanner.nextInt();

        if (mode == 0) {
//            foundMode=true;
            chooseMode = new Mode0();}
        else if (mode == 3) {
//            foundMode=true;
            chooseMode = new Mode3();
        }
        else if (mode ==27) {
         chooseMode = new Mode27();
         }
        
         if(chooseMode!=null)
             chooseMode.print();
         else {
             System.out.println("Invalid Mode");
         exit(1);
         }

        if (chooseMode.foundAnyError()) {
            OutputForModes.outputMessage(chooseMode.getMessage());
            System.out.println("Sudoku Solution is INVALID");
        } else {
            System.out.println("Sudoku Solution is VALID");
        }

    }
}
