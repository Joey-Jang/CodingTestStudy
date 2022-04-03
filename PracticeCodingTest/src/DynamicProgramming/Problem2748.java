package DynamicProgramming;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Problem2748 {
    private static List<Long> fibonacciList;

    public Problem2748() {
        fibonacciList = new ArrayList<>();
        fibonacciList.add(0L);
        fibonacciList.add(1L);
    }

    public static void main(String[] args) {
        new Problem2748();

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n : ");
        Integer n = sc.nextInt();
        fibonacci2(n);

        System.out.printf("%d", fibonacciList.get(n));
    }

    public static Long fibonacci2(Integer n) {
        if (n > fibonacciList.size()-1) {
            fibonacciList.add(fibonacciList.get(fibonacciList.size()-1) + fibonacciList.get(fibonacciList.size()-2));
            return fibonacci2(n);
        } else {
            return fibonacciList.get(n);
        }
    }
}
