import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String [] args) throws InterruptedException {
        int mode;
        var scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter mode(0-3-27)");
            if (scanner.hasNextInt()) {
                 mode = scanner.nextInt();
                if (mode == 0 || mode == 3 || mode == 27) {
                    break; 
                }
                else {
                    System.out.println("Invalid mode , please try again!");
                }
            } 
            else {
                System.out.println("Invalid input, please enter a number!");
            scanner.next(); // ignore the invalid input
         }
       }

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
        
        else if (mode==27){
            ArrayList<Mode27ForRows> rows = new ArrayList<>();
            ArrayList<Mode27ForColumns> cols = new ArrayList<>();
            ArrayList<Mode27ForBoxes> boxes = new ArrayList<>();
            ArrayList<Thread> threads = new ArrayList<>();

       // create 27 threads
           for (int i = 1; i <= 9; i++) {
                Mode27ForRows r = new Mode27ForRows(i);
                Mode27ForColumns c = new Mode27ForColumns(i);
                Mode27ForBoxes b = new Mode27ForBoxes(i);

                rows.add(r);
                cols.add(c);
                boxes.add(b);

                threads.add(new Thread(r));
                threads.add(new Thread(c));
                threads.add(new Thread(b));
         }

          for (int i = 0; i < threads.size(); i++) {
            threads.get(i).start();
         }
          for (int i = 0; i < threads.size(); i++) {
            threads.get(i).join();
        }

    // check if any thread found an error  
        boolean anyError = false;

        for (int i = 0; i < rows.size(); i++) {
            if (rows.get(i).foundAnyError()) {//Check if there is an error in any row
                anyError = true;
            } 
         }

        for (int i = 0; i < cols.size(); i++) {
            if (cols.get(i).foundAnyError()) {
                anyError = true;
            }
          }

        for (int i = 0; i < boxes.size(); i++) {
            if (boxes.get(i).foundAnyError()){
                anyError = true;
            }
         }

        for (int i = 0; i < rows.size(); i++) {
            OutputForModes.outputMessage(rows.get(i).getMessage());
            }

        for (int i = 0; i < cols.size(); i++) {
            OutputForModes.outputMessage(cols.get(i).getMessage());
            }

        for (int i = 0; i < boxes.size(); i++) {
            OutputForModes.outputMessage(boxes.get(i).getMessage());
        }
        
        if(anyError){
           System.out.println ("Sudoku Solution is INVALID");
        }
        else{
           System.out.println ("Sudoku Solution is VALID"); 
        }            
    }
  }
}




    }
}
