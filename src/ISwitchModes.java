import java.util.ArrayList;

public interface ISwitchModes {
    void print() throws InterruptedException;
    boolean foundAnyError();
    ArrayList <String> getMessage();
}

