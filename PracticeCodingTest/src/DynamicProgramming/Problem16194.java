package DynamicProgramming;

import java.util.*;
import java.util.stream.IntStream;

public class Problem16194 {
    private static final List<Integer> costList = new ArrayList<>();

    public static void init(int[] cardpackArr) {
        costList.add(cardpackArr[0]);
        if (cardpackArr.length >= 2) {
            costList.add(Math.min(costList.get(0)*2, cardpackArr[1]));
        }
        if (cardpackArr.length >= 3) {
            costList.add(Math.min(costList.get(0)+costList.get(1), cardpackArr[2]));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int totalCnt = Integer.parseInt(sc.nextLine());
        int[] cardpackArr = new int[totalCnt];
        for (int i=0; i<totalCnt; i++) {
            cardpackArr[i] = sc.nextInt();
        }

        init(cardpackArr);

        System.out.println(calMinCost(totalCnt, cardpackArr));
    }

    public static int calMinCost(int totalCnt, int[] cardpackArr) {
        if (totalCnt > costList.size()) {
            int nextMinCostIndex = IntStream.range(0, (costList.size()+1)/2)
                    .reduce((i,j) -> costList.get(i)+costList.get(costList.size()-1-i) < costList.get(j)+costList.get(costList.size()-1-j) ? i : j).getAsInt();
            costList.add(Math.min(costList.get(nextMinCostIndex)+costList.get(costList.size()-1-nextMinCostIndex), cardpackArr[costList.size()]));

            return calMinCost(totalCnt, cardpackArr);
        }

        return costList.get(totalCnt-1);
    }
}
