// --- Day 2: Corruption Checksum ---

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Day02 {

    public static void main(String[] args) throws Exception {

        List<List<Integer>> list = getInput();

        System.out.println(findCheckSum1(list));
        System.out.println(findCheckSum2(list));

    }

    private static int findCheckSum1(List<List<Integer>> list) {

        int sum = 0;

        for (List<Integer> l : list) {
            Collections.sort(l);
            sum += l.get(l.size()-1) - l.get(0);
        }

        return sum;

    }

    private static int findCheckSum2(List<List<Integer>> list) {

        int sum = 0;

        for (List<Integer> l : list) {
            for (int i=0;i<l.size();i++) {
                for (int j=0;j<l.size();j++) {
                    if (i!=j && l.get(i) >= l.get(j)) {
                        if(l.get(i)%l.get(j) == 0) {
                            sum += l.get(i)/l.get(j);
                        }
                    }
                }
            }
        }

        return sum;
    }

    private static List<List<Integer>> getInput() throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Enter the number of rows: ");
        int rows = Integer.parseInt(br.readLine());
        List<List<Integer>> list = new ArrayList<>();

        for (int i=0;i<rows;i++) {
            String[] strs = br.readLine().trim().split("\\s+");
            List<Integer> tempList = new ArrayList<>();

            for (int k=0;k<strs.length;k++) {
                tempList.add(Integer.parseInt(strs[k]));
            }

            list.add(tempList);
        }

        return list;
    }

}
