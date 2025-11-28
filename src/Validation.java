
import java.util.ArrayList;

public class Validation {
    

    public ArrayList<Integer>checkUnit(int[] arr) {
        int[] frequency = new int[10]; // frequency array
              // we won't use frequency[0]
        boolean flag = false;
        ArrayList<Integer>duplicate=new ArrayList<>();


        if (arr.length != 9) {
            duplicate.add(-1);
            System.out.println("invalid number of grid ");// error
            return duplicate;
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 1 || arr[i] > 9){
                duplicate.add(-1);
                System.out.println("invalid number ");// error
                return duplicate;
            }
            frequency[arr[i]]++;
        }

        for (int i = 1; i <= 9; i++) {
            if (frequency[i] > 1) {
                duplicate.add(i);
                flag = true;
            } 
        }

      return duplicate;  
    }
}