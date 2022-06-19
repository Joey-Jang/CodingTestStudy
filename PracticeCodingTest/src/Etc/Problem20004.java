package Etc;

import java.util.Scanner;

public class Problem20004 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();

        StringBuffer sb = new StringBuffer();
        for (int n=1; n<=A; n++) {
            if (30 %  (n + 1)== 0) {
                sb.append(n + "\n");
            }
        }

        System.out.println(sb);
    }
}
