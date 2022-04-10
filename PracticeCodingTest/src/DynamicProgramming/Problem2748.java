package DynamicProgramming;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Problem2748 {
    private static final List<Long> fibonacciList = new ArrayList<>();

    public static void init() {
        fibonacciList.add(0L);
        fibonacciList.add(1L);
    }

    public static void main(String[] args) {
        init();

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n : ");
        int n = sc.nextInt();
        fibonacci2(n);

        System.out.printf("%d", fibonacciList.get(n));
    }

    public static long fibonacci2(int n) {
        if (n > fibonacciList.size()-1) {
            fibonacciList.add(fibonacciList.get(fibonacciList.size()-1) + fibonacciList.get(fibonacciList.size()-2));
            return fibonacci2(n);
        } else {
            return fibonacciList.get(n);
        }
    }
}
