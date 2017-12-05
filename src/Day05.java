// --- Day 5: A Maze of Twisty Trampolines, All Alike ---

public class Day05 {

    public static void main(String[] args) {
        int[] arr = {0, 3, 0, 1, -3};

        // System.out.println(countSteps1(arr));
        System.out.println(countSteps2(arr));
    }

    private static int countSteps1(int[] arr) {
        int count = 0;
        int i = 0;

        while (i < arr.length) {
            int temp = i;
            i += arr[i];
            arr[temp]++;
            count++;
        }

        return count;
    }

    private static int countSteps2(int[] arr) {
        int count = 0;
        int i = 0;

        while (i < arr.length) {

            int temp = i;
            i += arr[i];

            if (arr[temp] >= 3) {
                arr[temp]--;
            }
            else {
                arr[temp]++;
            }

            count++;
        }

        return count;
    }
}
