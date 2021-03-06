package DynamicProgramming;

import java.util.Scanner;

public class Problem24418 {
    private static int recursiveCallCnt = 0;
    private static int DPCallCnt = 0;
    private static int[][] DPArr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of matrix, n : ");
        int n = Integer.parseInt(sc.nextLine());

        DPArr = new int[n+1][n+1];
        int[][] m = new int[n+1][n+1];
        for (int i=1; i<=n; i++) {
            if (i%10 == 1 && i != 11) {
                System.out.println("Enter 1st row : ");
            } else if (i%10 == 2 && i != 12) {
                System.out.println("Enter 2nd row : ");
            } else if (i%10 == 3 && i != 13) {
                System.out.println("Enter 3rd row : ");
            } else {
                System.out.printf("Enter %dth row : \n", i);
            }
            String row = sc.nextLine();
            String[] rowArr = row.split(" ");
            for (int j=1; j<=n; j++) {
                m[i][j] = Integer.parseInt(rowArr[j-1]);
            }
        }

        matrixPathRecursive(m, n);
        matrixPathDP(m, n);

        System.out.printf("%d %d", recursiveCallCnt, DPCallCnt);
    }

    public static int matrixPathRecursive(int[][] m, int n) {
        return matrixPathRecursive(m, n, n);
    }

    public static int matrixPathRecursive(int[][] m, int i, int j) {
        if (i == 0 || j == 0) {
            recursiveCallCnt++;
            return 0;
        } else {
            return m[i][j] + Math.max(matrixPathRecursive(m, i-1, j), matrixPathRecursive(m, i, j-1));
        }
    }

    public static int matrixPathDP(int[][] m, int n) {
        for (int i=0; i<=n; i++) {
            DPArr[i][0] = 0;
        }
        for (int j=1; j<=n; j++) {
            DPArr[0][j] = 0;
        }

        for (int i=1; i<=n; i++) {
            for (int j=1; j<=n; j++) {
                DPCallCnt++;
                DPArr[i][j] = m[i][j] + Math.max(DPArr[i-1][j], DPArr[i][j-1]);
            }
        }

        return DPArr[n][n];
    }
}
