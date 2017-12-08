import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

// --- Day 8: I Heard You Like Registers ---

public class Day08 {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Integer> map = new HashMap<>();
        int maxValEver = Integer.MIN_VALUE;

        int numOfLines = Integer.parseInt(br.readLine());

        while (numOfLines > 0) {

            String inp = br.readLine();

            String[] inpArr = inp.trim().split(" ");

            String register = inpArr[0];
            String operation = inpArr[1];
            int operationVal = Integer.parseInt(inpArr[2]);
            String checkRegister = inpArr[4];
            String condition = inpArr[5];
            int checkVal = Integer.parseInt(inpArr[6]);

            if (!map.containsKey(register)) map.put(register, 0);
            if (!map.containsKey(checkRegister)) map.put(checkRegister, 0);

            if (conditionIsTrue(map.get(checkRegister), condition, checkVal)) {
                if (operation.equals("inc")) {
                    map.put(register, map.get(register) + operationVal);
                }
                else {
                    map.put(register, map.get(register) - operationVal);
                }
            }

            maxValEver = Math.max(maxValEver, findMaxVal(map));

            numOfLines--;
        }

        System.out.println(findMaxVal(map));
        System.out.println(maxValEver);
    }

    private static int findMaxVal(Map<String, Integer> map) {

        int maxVal = Integer.MIN_VALUE;

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            maxVal = Math.max(maxVal, entry.getValue());
        }

        return maxVal;
    }

    private static boolean conditionIsTrue(int val1, String condition, int val2) {
        if (condition.equals("<")) {
            return val1 < val2;
        }
        else if (condition.equals(">")) {
            return val1 > val2;
        }
        else if (condition.equals(">=")) {
            return val1 >= val2;
        }
        else if (condition.equals("<=")) {
            return val1 <= val2;
        }
        else if (condition.equals("==")) {
            return val1 == val2;
        }
        else  {
            return val1 != val2;
        }
    }
}
