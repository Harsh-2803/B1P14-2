import java.util.*;

public class AccountSearchApp {

    static void linearSearch(String[] arr, String target) {
        int first = -1, last = -1, comparisons = 0;

        for (int i = 0; i < arr.length; i++) {
            comparisons++;
            if (arr[i].equals(target)) {
                if (first == -1) first = i;
                last = i;
            }
        }

        System.out.println("Linear first " + target + ": index " + first + " (" + comparisons + " comparisons)");
        System.out.println("Linear last " + target + ": index " + last);
    }

    static void binarySearch(String[] arr, String target) {
        int low = 0, high = arr.length - 1;
        int comparisons = 0;
        int found = -1;

        while (low <= high) {
            int mid = (low + high) / 2;
            comparisons++;

            if (arr[mid].equals(target)) {
                found = mid;
                break;
            } else if (arr[mid].compareTo(target) < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        int count = 0;
        if (found != -1) {
            int i = found;
            while (i >= 0 && arr[i].equals(target)) {
                count++;
                i--;
            }
            i = found + 1;
            while (i < arr.length && arr[i].equals(target)) {
                count++;
                i++;
            }
        }

        System.out.println("Binary " + target + ": index " + found + " (" + comparisons + " comparisons), count=" + count);
    }

    public static void main(String[] args) {

        String[] logs = {"accB", "accA", "accB", "accC"};

        Arrays.sort(logs);
        System.out.println("Sorted logs: " + Arrays.toString(logs));

        linearSearch(logs, "accB");
        binarySearch(logs, "accB");
    }
}