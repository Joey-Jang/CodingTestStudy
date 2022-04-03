package DynamicProgramming;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Problem24416 {
    private static final List<Integer> fibonacciList = new ArrayList<>();
    private static Integer countFib = 0;
    private static Integer countFibonacci = 0;

    public Problem24416() {
        fibonacciList.add(1);
        fibonacciList.add(1);
    }

    public static void main(String[] args) {
        new Problem24416();

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter num : ");
        Integer num = sc.nextInt();

        fib(num);
        fibonacci(num);

        System.out.printf("%d %d", countFib, countFibonacci);
    }

    public static Integer fib(Integer n) {
        if (n == 1 || n == 2) {
            countFib++;
            return 1;
        } else {
            return (fib(n-1) + fib(n-2));
        }
    }

    public static Integer fibonacci(Integer n) {
        if (n == 1 || n == 2) {
            return 1;
        } else {
            if (n > fibonacciList.size()) {
                countFibonacci++;
                fibonacciList.add(fibonacciList.get(fibonacciList.size()-2) + fibonacciList.get(fibonacciList.size()-1));
                return fibonacci(n);
            } else {
                return fibonacciList.get(n-1);
            }
        }
    }
}
