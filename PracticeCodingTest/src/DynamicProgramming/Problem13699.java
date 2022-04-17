package DynamicProgramming;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Problem13699 {
    private static List<Long> tList = new ArrayList<>();

    public static void init() {
        tList.add(1L);
    }

    public static void main(String[] args) {
        init();

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println(t(n));
    }

    public static long t(int n) {
        if (n > tList.size()-1) {
            long nextT = IntStream.range(0, tList.size()).mapToLong(i -> tList.get(i) * tList.get(tList.size()-1-i)).sum();
            tList.add(nextT);

            return t(n);
        }

        return tList.get(n);
    }
}
