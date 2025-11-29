import java.util.Scanner;

public class Main {
    public static void main(String [] args) throws InterruptedException {
        var scanner = new Scanner(System.in);
        System.out.println("Enter mode(0-3-27)");
        int mode = scanner.nextInt();
        if(mode==3) {
            var m1 = new Mode3Thread1ForRows();
            var m2 = new Mode3Thread2ForColumns();
            var m3 = new Mode3Thread3ForBoxes();
            Thread t1 = new Thread(m1);
            Thread t2 = new Thread(m2);
            Thread t3 = new Thread(m3);
            t1.start();
            t2.start();
            t3.start();
            t1.join();
            t2.join();
            t3.join();

            if (!m1.foundAnyError() && !m2.foundAnyError() && !m3.foundAnyError()) {

                System.out.println("Sudoku Solution is VALID ");
            } else {
                OutputForModes.outputMessage(m1.getMessage());
                OutputForModes.outputMessage(m2.getMessage());
                OutputForModes.outputMessage(m3.getMessage());
                System.out.println("Sudoku Solution is INVALID ");
            }

        }
        else if (mode==0)
        {
            System.out.println("mode0");
            var mode0=new Mode0();
            if (!mode0.foundAnyError()) {

                System.out.println("Sudoku Solution is VALID ");
            } else {
                OutputForModes.outputMessage(mode0.getMessage());
                System.out.println("Sudoku Solution is INVALID ");
            }
        }




    }
}