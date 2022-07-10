package GraphTheory;

import java.util.Scanner;

public class Problem11123 {

    private static int[] dr = {0, 0, 1, -1};
    private static int[] dc = {1, -1, 0, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int testCase = sc.nextInt();

        for (int i=0; i<testCase; i++) {
            int H = sc.nextInt();
            int W = sc.nextInt();
            sc.nextLine();

            char[][] grid = new char[H][W];

            for (int r=0; r<H; r++) {
                String line = sc.nextLine();
                for (int c=0; c<W; c++) {
                    char sheep = line.charAt(c);
                    grid[r][c] = sheep;
                }
            }

            int groupCount = 0;

            for (int r=0; r<H; r++) {
                for (int c=0; c<W; c++) {
                    if (grid[r][c] == '#') {
                        groupCount++;
                        checkGroup(grid, H, W, r, c, groupCount);
                    }
                }
            }

            System.out.println(groupCount);
        }
    }

    public static void checkGroup(char[][] grid, int H, int W, int r, int c, int groupCount) {
        if (grid[r][c] == '#') {
            grid[r][c] = (char) (groupCount - '0');

            for (int d=0; d<4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];

                if (nr >= 0 && nr < H && nc >= 0 && nc < W) {
                    checkGroup(grid, H, W, nr, nc, groupCount);
                }
            }
        }
    }
}
