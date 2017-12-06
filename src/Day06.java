import java.util.*;

// --- Day 6: Memory Reallocation ---

public class Day06 {

    public static int CycleIteratorCount = -1;

    public static void main(String[] args) {

        int[] arr = {14, 0, 15, 12, 11, 11, 3, 5, 1, 6, 8, 4, 9, 1, 8, 4};

        System.out.println(getCycleCount(arr));
        System.out.println(CycleIteratorCount);
    }

    private static int getCycleCount(int[] arr) {

        Map<String, Integer> map = new HashMap<>();

        int count = 0;

        map.put(Arrays.toString(arr), count);

        while (true) {
            int max = Integer.MIN_VALUE;
            int ind = -1;

            for (int i=0; i<arr.length; i++) {
                if (arr[i] > max) {
                    max = arr[i];
                    ind = i;
                }
            }

            arr[ind] = 0;
            ind++;

            while (max > 0) {

                if (ind == arr.length) ind = 0;

                arr[ind]++;
                max--;
                ind++;
            }

            count++;

            if (map.containsKey(Arrays.toString(arr))) {
                CycleIteratorCount = count - map.get(Arrays.toString(arr));
                break;
            }

            map.put(Arrays.toString(arr), count);
        }

        return count;
    }
}
