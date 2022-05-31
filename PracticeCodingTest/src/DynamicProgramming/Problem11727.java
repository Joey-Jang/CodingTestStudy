package DynamicProgramming;

import java.math.BigInteger;
import java.util.Scanner;

public class Problem11727 {
    private static final BigInteger B10007 = BigInteger.valueOf(10007);
    private static final BigInteger B2 = BigInteger.valueOf(2);

    public static void main(String[] args) {
        BigInteger result = BigInteger.ZERO;

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int num2 = 0;
        while (n - num2 * 2 >= 0) {
            result = result.add(combination((n - num2 * 2) + num2, num2).multiply(B2.pow(num2)));

            num2++;
        }

        System.out.println(result.remainder(B10007));
    }

    public static BigInteger combination(int n, int m) {
        BigInteger result = BigInteger.ONE.negate();

        if (n >= m) {
            result = factorial(n).divide(factorial(n-m).multiply(factorial(m)));
        }

        return result;
    }

    public static BigInteger factorial(int n) {
        if (n < 0) return BigInteger.ONE.negate();

        if (n == 0) {
            return BigInteger.ONE;
        } else {
            return BigInteger.valueOf(n).multiply(factorial(n-1));
        }
    }
}
