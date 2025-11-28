public class FormatArray {
    public static String formatArray(int[] arr) {
        String s = "[";

        for (int i = 0; i < arr.length; i++) {
            s+=arr[i];
            if (i <arr.length - 1) s+=", ";
        }
        return s+"]";
    }
}
