package DynamicProgramming;

import java.util.Scanner;

public class Problem9656 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        N = N % 4;

        if (N == 1 || N == 3) System.out.println("CY");
        else System.out.println("SK");

        /*
        * 1 x
        * 2 o -> 1 x
        * 3 x -> 2 o
        * 4 o -> 1 x or 3 x
        * 5 x -> 2 o or 4 o
        * 6 o -> 3 x or 5 x
        * 7 x -> 4 o or 6 o
        * 8 o -> 5 x or 7 x
        * 9 x -> 6 o or 8 o
        * 10 o -> 7 x or 9 x
        * 11 x -> 8 o or 10 o
        * */
    }
}
