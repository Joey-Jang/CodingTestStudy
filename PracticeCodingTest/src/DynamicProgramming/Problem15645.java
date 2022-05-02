package DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Problem15645 {
    private static int[][] minScoreArr;
    private static int[][] maxScoreArr;

    public static void init(int cnt) {
        minScoreArr = new int[cnt][3];
        maxScoreArr = new int[cnt][3];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int cnt = sc.nextInt();
        init(cnt);

        for (int i=0; i<cnt; i++) {
            for (int j=0; j<3; j++) {
                int num = sc.nextInt();
                minScoreArr[i][j] = num;
                maxScoreArr[i][j] = num;
            }
            if (i != 0) {
                calNextMinScore(i);
                calNextMaxScore(i);
            }
        }

        System.out.printf("%d %d", Arrays.stream(maxScoreArr[maxScoreArr.length-1]).max().getAsInt(), Arrays.stream(minScoreArr[minScoreArr.length-1]).min().getAsInt());
    }

    public static void calNextMinScore(int rowIndex) {
        minScoreArr[rowIndex][0] += Math.min(minScoreArr[rowIndex-1][0], minScoreArr[rowIndex-1][1]);
        minScoreArr[rowIndex][1] += Math.min(Math.min(minScoreArr[rowIndex-1][0], minScoreArr[rowIndex-1][1]), minScoreArr[rowIndex-1][2]);
        minScoreArr[rowIndex][2] += Math.min(minScoreArr[rowIndex-1][1], minScoreArr[rowIndex-1][2]);
    }

    public static void calNextMaxScore(int rowIndex) {
        maxScoreArr[rowIndex][0] += Math.max(maxScoreArr[rowIndex-1][0], maxScoreArr[rowIndex-1][1]);
        maxScoreArr[rowIndex][1] += Math.max(Math.max(maxScoreArr[rowIndex-1][0], maxScoreArr[rowIndex-1][1]), maxScoreArr[rowIndex-1][2]);
        maxScoreArr[rowIndex][2] += Math.max(maxScoreArr[rowIndex-1][1], maxScoreArr[rowIndex-1][2]);
    }
}
