package DynamicProgramming;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Problem14606 {
    private static List<Integer> pleasureList;

    public Problem14606() {
        pleasureList = new ArrayList<>();
        pleasureList.add(0);
        pleasureList.add(0);
    }

    public static void main(String[] args) {
        new Problem14606();

        Scanner sc = new Scanner(System.in);
        Integer N = sc.nextInt();

        System.out.println(calcPleasure(N));
    }

    public static Integer calcPleasure(Integer N) {
        if (N > pleasureList.size()-1) {
            pleasureList.add(pleasureList.size()-1 + pleasureList.get(pleasureList.size()-1));
            return calcPleasure(N);
        } else {
            return pleasureList.get(N);
        }
    }
}
