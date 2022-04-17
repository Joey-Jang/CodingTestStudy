package DynamicProgramming;

import java.util.Scanner;

public class Problem9656 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        N = N % 4;

        if (N == 1 || N == 3) System.out.println("CY");
        else System.out.println("SK");
    }
}
