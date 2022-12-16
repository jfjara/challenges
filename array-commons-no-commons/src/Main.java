import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        int[] array1 = new int[] {1, 2, 3, 3, 4};
        int[] array2 = new int[] {2, 2, 3, 3, 4, 6};
        List<Integer> result = extract(array1, array2, true);
        result.forEach(e -> System.out.print(e + " "));
    }

    private static List<Integer> extracCommons(int[] array1, int[] array2) {
        int[] totalArray = concatArrays(array1, array2);
        List<Integer> set = new ArrayList<>();
        for (int i = 0; i < totalArray.length; i++) {
            boolean elementFound = false;
            int element = totalArray[i];
            if (!isProcessed(element, set)) {
                for (int j = i + 1; j < totalArray.length; j++) {
                    if (element == totalArray[j]) {
                        elementFound = true;
                        set.add(totalArray[j]);
                    }
                }
                if (elementFound) {
                    set.add(element);
                }
            }
        }
        return set;
    }

    private static List<Integer> extract(int[] array1, int[] array2, boolean b) {
        return b ? extracCommons(array1, array2) : extracNoCommons(array1, array2);
    }

    private static List<Integer> extracNoCommons(int[] array1, int[] array2) {
        int[] totalArray = concatArrays(array1, array2);
        List<Integer> set = new ArrayList<>();
        for (int i = 0; i < totalArray.length; i++) {
            boolean elementFound = false;
            int element = totalArray[i];

            for (int j = 0; j < totalArray.length; j++) {
                if (i != j && element == totalArray[j]) {
                    elementFound = true;
                }
            }

            if (!elementFound) {
                set.add(element);
            }
        }
        return set;
    }

    private static boolean isProcessed(int element, List<Integer> set) {
        return set.contains(element);
    }

    static int[] concatArrays(int[] array1, int[] array2) {
        return IntStream.concat(Arrays.stream(array1), Arrays.stream(array2)).toArray();
    }

}
