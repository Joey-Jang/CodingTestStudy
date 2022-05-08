package DynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

public class Problem11722 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int length = sc.nextInt();
        int[] sequence = new int[length];
        int[] dp = new int[length];

        for (int i=0; i<length; i++) {
            int num = sc.nextInt();
            sequence[i] = num;
            dp[i] = num;
        }

        for (int j=0; j<length; j++) {
            dp[j] = 1;
            for (int k=0; k<j; k++) {
                if (sequence[j] < sequence[k]) {
                    dp[j] = Math.max(dp[j], dp[k] + 1);
                }
            }
        }

        int result = Arrays.stream(dp).max().getAsInt();
        System.out.println(result);
    }
}
