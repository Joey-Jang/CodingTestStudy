package DynamicProgramming;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Problem2839 {
    private static final List<Integer> sugarList = new ArrayList<>();
    private static final int SUGAR_3 = 3;
    private static final int SUGAR_5 = 5;

    public static void init() {
        sugarList.add(-1);
        sugarList.add(-1);
        sugarList.add(-1);
        sugarList.add(1);
        sugarList.add(-1);
        sugarList.add(1);
    }

    public static void main(String[] args) {
        init();

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter total sugar : ");
        int totalSugar = sc.nextInt();

        System.out.printf("%d\n", calcSugar(totalSugar));
    }

    public static int calcSugar(int totalSugar) {
        if (totalSugar > sugarList.size()-1) {
            if (sugarList.get(sugarList.size() - SUGAR_5) != -1) {
                sugarList.add(sugarList.get(sugarList.size() - SUGAR_5) + 1);
            } else if (sugarList.get(sugarList.size() - SUGAR_3) != -1) {
                sugarList.add(sugarList.get(sugarList.size() - SUGAR_3) + 1);
            } else {
                sugarList.add(-1);
            }

            return calcSugar(totalSugar);
        } else {
            return sugarList.get(totalSugar);
        }
    }

    public static int calcSugar2(int totalSugar) {
        int result = 0;

        while (totalSugar > 0 && totalSugar % SUGAR_5 != 0) {
            totalSugar = totalSugar - SUGAR_3;

            result++;
        }

        result = (totalSugar > 0) ? (result + totalSugar / SUGAR_5) : -1;

        return result;
    }
}
