import java.util.ArrayList;

public class Mode27 implements ISwitchModes {

    private boolean anyError = false;
    private ArrayList<String> allMessages = new ArrayList<>();
    ArrayList<Thread> threads = new ArrayList<>(); // as thread is defined inside block
    ArrayList<Mode27ForRows> rows = new ArrayList<>();
    ArrayList<Mode27ForColumns> cols = new ArrayList<>();
    ArrayList<Mode27ForBoxes> boxes = new ArrayList<>();


    @Override
    public void print() throws InterruptedException {
        for (int i = 1; i <= 9; i++) {
            Mode27ForRows r = new Mode27ForRows(i);
            rows.add(r);
            Thread t1 = new Thread(r);
            t1.start();
            threads.add(t1);
        }
        for (int i = 1; i <= 9; i++) {
            Mode27ForColumns c = new Mode27ForColumns(i);
            cols.add(c);
            Thread t2 = new Thread(c);
            t2.start();
            threads.add(t2);
        }
        for (int i = 1; i <= 9; i++) {
            Mode27ForBoxes b = new Mode27ForBoxes(i);
            boxes.add(b);
            Thread t3 = new Thread(b);
            t3.start();
            threads.add(t3);

        }
        for( Thread t: threads)  t.join(); // main wait till all threads finish

        //messages to  be added if error is found
        for (Mode27ForRows r : rows) {
            if (r.foundAnyError()) anyError = true;
            allMessages.addAll(r.getMessage());

        }
        allMessages.add("-------------------------\n");



        for (Mode27ForColumns c : cols) {
            if (c.foundAnyError()) anyError = true;
            allMessages.addAll(c.getMessage());

        }
        allMessages.add("-------------------------\n");


        for (Mode27ForBoxes b : boxes) {
            if (b.foundAnyError()) anyError = true;
            allMessages.addAll(b.getMessage());

        }
        allMessages.add("-------------------------\n");

    }
    @Override
    public boolean foundAnyError() {
        return anyError;
    }

    @Override
    public ArrayList<String> getMessage() {
        return allMessages;
    }
}
