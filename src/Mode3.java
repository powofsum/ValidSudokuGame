import java.util.ArrayList;

public class Mode3 implements ISwitchModes{
    private boolean anyError = false;
    private ArrayList<String> allMessages = new ArrayList<>();
    @Override
    public void print() throws InterruptedException {
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
        allMessages.addAll(m1.getMessage());
        allMessages.add("-------------------------\n");
        allMessages.addAll(m2.getMessage());
        allMessages.add("-------------------------\n");
        allMessages.addAll(m3.getMessage());
        anyError = m1.foundAnyError() || m2.foundAnyError() || m3.foundAnyError();


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
