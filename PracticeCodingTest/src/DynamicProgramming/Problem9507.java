package DynamicProgramming;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Problem9507 {
    private static List<Long> koongList = new ArrayList<>();

    public static void init() {
        koongList.add(1L);
        koongList.add(1L);
        koongList.add(2L);
        koongList.add(4L);
    }

    public static void main(String[] args) {
        init();

        Scanner sc = new Scanner(System.in);
        int caseCnt = sc.nextInt();

        for (int i=0; i<caseCnt; i++) {
            int n = sc.nextInt();
            System.out.println(koong(n));
        }
    }

    public static long koong(int n) {
        if (n > koongList.size() - 1) {
            koongList.add(koongList.get(koongList.size()-1) + koongList.get(koongList.size()-2) + koongList.get(koongList.size()-3) + koongList.get(koongList.size()-4));

            return koong(n);
        }

        return koongList.get(n);
    }
}
