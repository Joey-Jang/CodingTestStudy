package DynamicProgramming;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Problem24416 {
    private static final List<Integer> fibonacciList = new ArrayList<>();
    private static int countFib = 0;
    private static int countFibonacci = 0;

    public static void init() {
        fibonacciList.add(1);
        fibonacciList.add(1);
    }

    public static void main(String[] args) {
        init();

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter num : ");
        Integer num = sc.nextInt();

        fib(num);
        fibonacci(num);

        System.out.printf("%d %d", countFib, countFibonacci);
    }

    public static int fib(int n) {
        if (n == 1 || n == 2) {
            countFib++;
            return 1;
        } else {
            return (fib(n-1) + fib(n-2));
        }
    }

    public static int fibonacci(int n) {
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
