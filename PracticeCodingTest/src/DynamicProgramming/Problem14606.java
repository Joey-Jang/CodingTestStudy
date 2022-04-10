package DynamicProgramming;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Problem14606 {
    private static final List<Integer> pleasureList = new ArrayList<>();

    public static void init() {
        pleasureList.add(0);
        pleasureList.add(0);
    }

    public static void main(String[] args) {
        init();

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        System.out.println(calcPleasure(N));
    }

    public static int calcPleasure(int N) {
        if (N > pleasureList.size()-1) {
            pleasureList.add(pleasureList.size()-1 + pleasureList.get(pleasureList.size()-1));
            return calcPleasure(N);
        } else {
            return pleasureList.get(N);
        }
    }
}
