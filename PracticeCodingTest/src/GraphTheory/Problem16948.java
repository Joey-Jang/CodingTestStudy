package GraphTheory;

import java.util.*;

public class Problem16948 {
    private static int shortestMove = -1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int size = sc.nextInt();

        int startR = sc.nextInt();
        int startC = sc.nextInt();
        int endR = sc.nextInt();
        int endC = sc.nextInt();

        int dr = Math.abs(endR - startR);
        int dc = Math.abs(endC - startC);

        if (dr % 2 == 0) {
            if ((dc - (dr / 2)) % 2 == 0) {
                shortestMove = dr / 2 + (dc - (dr / 2) > 0 ? (dc - (dr / 2)) / 2 : 0);
            }
        }

        System.out.println(shortestMove);
    }
}
