package DynamicProgramming;

import java.util.Scanner;

public class Problem3976 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("테스트 케이스 개수 : ");
        int caseCnt = Integer.parseInt(sc.nextLine());

        for (int i=0; i<caseCnt; i++) {
            System.out.println("점 개수, 수비수 첫 패스 난이도, 슛 난이도 : ");
            String[] info = sc.nextLine().split(" ");
            int nodeCnt = Integer.parseInt(info[0]); // Number of Nodes
            int DPassS1 = Integer.parseInt(info[1]); // Difficulty that Defender PASS to Striker1
            int DPassS2 = Integer.parseInt(info[2]); // Difficulty that Defender PASS to Striker2
            int S1Shoot = Integer.parseInt(info[3]); // Difficulty that Striker1 SHOOT
            int S2Shoot = Integer.parseInt(info[4]); // Difficulty that Striker2 SHOOT
            System.out.println("1번 선수 -> 2번 선수 패스 난이도 : ");
            String[] S1PassS2 = sc.nextLine().split(" "); // Difficulty that Striker1 PASS to Striker2
            System.out.println("1번 선수 드리블 패스 난이도 : ");
            String[] S1Dribble = sc.nextLine().split(" "); // Difficulty that Striker1 DRIBBLE
            System.out.println("2번 선수 -> 1번 선수 패스 난이도 : ");
            String[] S2PassS1 = sc.nextLine().split(" "); // Difficulty that Striker2 PASS to Striker1
            System.out.println("2번 선수 드리블 난이도 : ");
            String[] S2Dribble = sc.nextLine().split(" "); // Difficulty that Striker2 DRIBBLE

            int[][] difficultyArr = new int[nodeCnt+1][2];
            difficultyArr[0][0] = DPassS1;
            difficultyArr[0][1] = DPassS2;

            for (int j=1; j<=nodeCnt-1; j++) {
                difficultyArr[j][0] = Math.min(difficultyArr[j-1][0] + Integer.parseInt(S1Dribble[j-1]), difficultyArr[j-1][1] + Integer.parseInt(S2PassS1[j-1]));
                difficultyArr[j][1] = Math.min(difficultyArr[j-1][1] + Integer.parseInt(S2Dribble[j-1]), difficultyArr[j-1][0] + Integer.parseInt(S1PassS2[j-1]));
            }

            difficultyArr[nodeCnt][0] = difficultyArr[nodeCnt-1][0] + S1Shoot;
            difficultyArr[nodeCnt][1] = difficultyArr[nodeCnt-1][1] + S2Shoot;

            System.out.println(Math.min(difficultyArr[nodeCnt][0], difficultyArr[nodeCnt][1]));
        }
    }
}
