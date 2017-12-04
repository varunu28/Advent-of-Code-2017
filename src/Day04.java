// --- Day 4: High-Entropy Passphrases ---

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Day04 {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int numInputs = 512;
        int count = 0;

        for (int i=1;i<=numInputs;i++) {
            String s = br.readLine();
            if (isValidPassPhrase2(s)) {
                count++;
            }
        }

        System.out.println(count);
    }

    private static boolean isValidPassPhrase1(String s) {

        String[] arrS = s.trim().split("\\s+");

        Set<String>  arrSet = Arrays.stream(arrS).collect(Collectors.toSet());

        return arrS.length == arrSet.size();
    }

    private static boolean isValidPassPhrase2(String s) {

        String[] arrS = s.trim().split("\\s+");

        Set<String> arrSet = new HashSet<>();

        for (String str : arrS) {
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String sortStr = String.valueOf(arr);

            arrSet.add(sortStr);
        }

        return arrS.length == arrSet.size();
    }
}
