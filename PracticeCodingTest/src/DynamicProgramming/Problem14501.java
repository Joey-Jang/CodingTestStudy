package DynamicProgramming;

import java.util.Scanner;

public class Problem14501 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int dDay = sc.nextInt();
        int[] time = new int[dDay + 1];
        int[] pay = new int[dDay + 1];
        int[] dp = new int[dDay + 1];

        for (int i=0; i<dDay; i++) {
            time[i] = sc.nextInt();
            pay[i] = sc.nextInt();
        }

        for (int i=1; i<=dDay; i++) {
            for (int j=1; j<=i; j++) {
                if (j + time[j] - 1 <= i) {
                    dp[i] = Math.max(dp[i], dp[j - 1] + pay[j]);
                }
            }
        }

        System.out.println(dp[dDay]);
    }
}
