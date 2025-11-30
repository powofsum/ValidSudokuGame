import java.util.ArrayList;

public class Mode27 implements ISwitchModes {

    private boolean anyError = false;
    private ArrayList<String> allMessages = new ArrayList<>();

    @Override
    public void print() throws InterruptedException {
        for (int i = 1; i <= 9; i++) {
            Mode27ForRows r = new Mode27ForRows(i);
            Thread t1 = new Thread(r);
            t1.start();
            t1.join();

            if (r.foundAnyError()){
                anyError = true;
            }
            allMessages.addAll(r.getMessage());
        }
        for (int i = 1; i <= 9; i++) {
            Mode27ForColumns c = new Mode27ForColumns(i);
            Thread t2 = new Thread(c);
            t2.start();
            t2.join();
            if (c.foundAnyError()){
                anyError = true;
            }
            allMessages.addAll(c.getMessage());
        }
        for (int i = 1; i <= 9; i++) {
            Mode27ForBoxes b = new Mode27ForBoxes(i);
            Thread t3 = new Thread(b);
            t3.start();
            t3.join();
            if (b.foundAnyError()){
                anyError = true;
            }
            allMessages.addAll(b.getMessage());
        }
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
