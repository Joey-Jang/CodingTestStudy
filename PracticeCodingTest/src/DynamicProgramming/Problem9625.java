package DynamicProgramming;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Problem9625 {
    private static List<Integer> AList;
    private static List<Integer> BList;

    public Problem9625() {
        AList = new ArrayList<>();
        AList.add(1);
        AList.add(0);

        BList = new ArrayList<>();
        BList.add(0);
        BList.add(1);
    }

    public static void main(String[] args) {
        new Problem9625();

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter K : ");
        int k = sc.nextInt();
        sc.close();

        button(k);

        System.out.printf("%d %d", AList.get(k), BList.get(k));
    }



    public static void button(int k) {
        if (k == 0 || k == 1) {
            return;
        } else {
            if (k > AList.size()-1) {
                AList.add(AList.get(AList.size()-2) + AList.get(AList.size()-1));
                BList.add(BList.get(BList.size()-2) + BList.get(BList.size()-1));
                button(k);
            } else {
                return;
            }
        }
    }
}
