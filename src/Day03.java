// --- Day 3: Spiral Memory ---

import java.util.ArrayList;

public class Day03 {

    public static void main(String[] args) {
        int n = 325489;
        System.out.println(findManDist(n));
    }

    public static int findManDist(int n) {
        int i = 1;

        while (i*i < n) {
            i += 2;
        }

        ArrayList<Integer> pivots = new ArrayList<>();

        for (int k=0;k<4;k++) {
            pivots.add(i*i - k*(i-1));
        }

        for (int p: pivots) {
            if (Math.abs(p - n) <= (i-1)/2) {
                return i - 1 - Math.abs(p-n);
            }
        }

        return -1;
    }
}
