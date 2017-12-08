import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

// --- Day 7: Recursive Circus ---

public class Day07 {

    public static void main(String[] args) throws Exception {

        System.out.println(solve1());
    }

    private static String solve1() throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        List<String> programs = new ArrayList<>();
        List<String> support = new ArrayList<>();

        // Input Parsing
        while (n > 0) {
            String s = br.readLine();

            if (s.contains("->")) {
                String[] strs = s.split("->");
                String[] supportingPrograms = strs[1].split(",");
                for (int i=0;i<supportingPrograms.length;i++) {
                    support.add(supportingPrograms[i].trim());
                }

                programs.add(strs[0].split(" ")[0].trim());
            }
            else {
                String[] strs = s.split(" ");
                programs.add(strs[0].trim());
            }

            n--;
        }

        String ans = "";

        for (String prog: programs) {
            if (!support.contains(prog)) {
                ans = prog;
            }
        }

        return ans;
    }
}

class Disc {

    private String name;
    private int weight;
    private ArrayList<Disc> childrens;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public ArrayList<Disc> getChildrens() {
        return childrens;
    }

    public void setChildrens(ArrayList<Disc> childrens) {
        this.childrens = childrens;
    }

    public int getTotalWeight() {

        int total = this.weight;
        for (Disc disc : this.childrens) {
            total += disc.getTotalWeight();
        }

        return total;
    }
}