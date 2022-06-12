package GraphTheory;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Problem2210 {
    private static int[][] digits = new int[5][5];
    private static Set<Integer> sixDigits = new HashSet<>();

    private static int[] dx = {0, 0, 1, -1};
    private static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int x=0; x<5; x++) {
            for (int y=0; y<5; y++) {
                digits[x][y] = sc.nextInt();
            }
        }

        for (int x=0; x<5; x++) {
            for (int y=0; y<5; y++) {
                calcPath(x, y, digits[x][y], 1);
            }
        }

        System.out.println(sixDigits.size());
    }

    public static void calcPath(int x, int y, int num, int len) {
        if (len == 6) {
            sixDigits.add(num);
            return;
        }

        for (int d=0; d<4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (nx >= 0 && nx < 5 && ny >= 0 && ny < 5) {
                calcPath(nx, ny, num * 10 + digits[nx][ny], len + 1);
            }
        }
    }
}
