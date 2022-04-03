package DynamicProgramming;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Problem2839 {
    private static List<Integer> sugarList;
    private static final Integer SUGAR_3 = 3;
    private static final Integer SUGAR_5 = 5;

    public Problem2839() {
        this.sugarList = new ArrayList<>();
        sugarList.add(-1);
        sugarList.add(-1);
        sugarList.add(-1);
        sugarList.add(1);
        sugarList.add(-1);
        sugarList.add(1);
    }

    public static void main(String[] args) {
        new Problem2839();

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter total sugar : ");
        Integer totalSugar = sc.nextInt();

        System.out.printf("%d\n", calcSugar2(totalSugar));
    }

    public static Integer calcSugar(Integer totalSugar) {
        if (totalSugar > sugarList.size()-1) {
            if (sugarList.get(sugarList.size()-5) != -1) {
                sugarList.add(sugarList.get(sugarList.size()-5) + 1);
            } else if (sugarList.get(sugarList.size()-3) != -1) {
                sugarList.add(sugarList.get(sugarList.size()-3) + 1);
            } else {
                sugarList.add(-1);
            }
            return calcSugar(totalSugar);
        } else {
            return sugarList.get(totalSugar);
        }
    }

    public static Integer calcSugar2(Integer totalSugar) {
        Integer result = 0;

        while (totalSugar % 5 != 0) {
            totalSugar = totalSugar - 3;
            result++;
        }

        if (totalSugar % 5 == 0) {
            result += totalSugar / 5;
        } else {
            result = -1;
        }

        return result;
    }
}
