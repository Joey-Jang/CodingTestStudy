package GraphTheory;

import java.util.*;

public class Problem3187 {

    private static int R;
    private static int C;
    private static char[][] inputGrid;
    private static Integer[][] groupGrid;
    private static int groupCount = 0;
    private static Map<Integer, int[]> groupInfo = new HashMap<>();
    private static int[] totalSheepAndWolves = new int[2];

    public static void init(int row, int column) {
        R = row;
        C = column;
        inputGrid = new char[R][C];
        groupGrid = new Integer[R][C];
    }

    private static int[] dr = {0, 0, 1, -1};
    private static int[] dc = {1, -1, 0, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int row = sc.nextInt();
        int column = sc.nextInt();
        sc.nextLine();
        init(row, column);

        for (int r=0; r<R; r++) {
            String line = sc.nextLine();
            for (int c=0; c<C; c++) {
                char chr = line.charAt(c);
                inputGrid[r][c] = chr;
            }
        }

        preprocessGridBoundary();

        postprocessGridInside();

        calcSheepAndWolves();

        System.out.printf("%d %d", totalSheepAndWolves[0], totalSheepAndWolves[1]);
    }

    public static void preprocessGridBoundary() {
        for (int c=0; c<C; c++) {
            if (inputGrid[0][c] != '#' && groupGrid[0][c] == null) {
                noGroup(0, c);
            }
            if (inputGrid[R-1][c] != '#' && groupGrid[R-1][c] == null) {
                noGroup(R-1, c);
            }
        }

        for (int r=1; r<R-1; r++) {
            if (inputGrid[r][0] != '#' && groupGrid[r][0] == null) {
                noGroup(r, 0);
            }
            if (inputGrid[r][C-1] != '#' && groupGrid[r][C-1] == null) {
                noGroup(r, C-1);
            }
        }
    }

    public static void postprocessGridInside() {
        for (int r=0; r<R; r++) {
            for (int c=0; c<C; c++) {
                if (inputGrid[r][c] != '#' && groupGrid[r][c] == null) {
                    groupCount++;
                    groupInfo.put(groupCount, new int[2]);
                    bindGroup(r, c);
                }
            }
        }
    }

    public static void bindGroup(int r, int c) {
        if (inputGrid[r][c] != '#' && groupGrid[r][c] == null) {
            groupGrid[r][c] = groupCount;

            int[] sheepAndWolves = groupInfo.get(groupCount);
            if (inputGrid[r][c] == 'k') {
                sheepAndWolves[0]++;
            } else if (inputGrid[r][c] == 'v') {
                sheepAndWolves[1]++;
            }

            for (int d=0; d<4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];

                if (nr >= 0 && nr < R && nc >= 0 && nc < C) {
                    bindGroup(nr, nc);
                }
            }
        }
    }

    public static void noGroup(int r, int c) {
        if (inputGrid[r][c] != '#' && groupGrid[r][c] == null) {
            groupGrid[r][c] = -1;

            for (int d=0; d<4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];

                if (nr >= 0 && nr < R && nc >= 0 && nc < C) {
                    noGroup(nr, nc);
                }
            }
        }
    }

    public static void calcSheepAndWolves() {
        Set<Integer> groupKeySet = groupInfo.keySet();
        Iterator<Integer> groupKeyIterator = groupKeySet.iterator();

        while (groupKeyIterator.hasNext()) {
            int groupKey = groupKeyIterator.next();
            int[] sheepAndWolves = groupInfo.get(groupKey);

            int sheep = sheepAndWolves[0];
            int wolves = sheepAndWolves[1];

            if (sheep > wolves) {
                totalSheepAndWolves[0] += sheep;
            } else {
                totalSheepAndWolves[1] += wolves;
            }
        }
    }
}
