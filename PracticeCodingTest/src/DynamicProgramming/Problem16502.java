package DynamicProgramming;

import java.util.*;

public class Problem16502 {
    private final static double[] possibilities = {0.25, 0.25, 0.25, 0.25};
    private final static Map<String, Double> mapA = new HashMap<>();
    private final static Map<String, Double> mapB = new HashMap<>();
    private final static Map<String, Double> mapC = new HashMap<>();
    private final static Map<String, Double> mapD = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("쇼핑 시간 : ");
        int shoppingMinute = Integer.parseInt(sc.nextLine());
        System.out.println("간선의 개수 : ");
        int edgeCnt = Integer.parseInt(sc.nextLine());

        for (int i=0; i<edgeCnt; i++) {
            System.out.printf("%d번째 간선 정보 : \n", i+1);
            String[] info = sc.nextLine().split(" ");
            String from = info[0];
            String to = info[1];
            String possibility = info[2];
            switch (to) {
                case "A" -> mapA.put(from, Double.parseDouble(possibility));
                case "B" -> mapB.put(from, Double.parseDouble(possibility));
                case "C" -> mapC.put(from, Double.parseDouble(possibility));
                case "D" -> mapD.put(from, Double.parseDouble(possibility));
            }
        }

        for (int i=0; i<shoppingMinute; i++) {
            calcPossibility();
        }

        System.out.printf("%.2f\n", possibilities[0] * 100);
        System.out.printf("%.2f\n", possibilities[1] * 100);
        System.out.printf("%.2f\n", possibilities[2] * 100);
        System.out.printf("%.2f\n", possibilities[3] * 100);
    }

    public static void calcPossibility() {
        double prevA = possibilities[0];
        double prevB = possibilities[1];
        double prevC = possibilities[2];
        double prevD = possibilities[3];

        possibilities[0] = prevA * mapA.getOrDefault("A", 0.00)
                + prevB * mapA.getOrDefault("B", 0.00)
                + prevC * mapA.getOrDefault("C", 0.00)
                + prevD * mapA.getOrDefault("D", 0.00);
        possibilities[1] = prevA * mapB.getOrDefault("A", 0.00)
                + prevB * mapB.getOrDefault("B", 0.00)
                + prevC * mapB.getOrDefault("C", 0.00)
                + prevD * mapB.getOrDefault("D", 0.00);
        possibilities[2] = prevA * mapC.getOrDefault("A", 0.00)
                + prevB * mapC.getOrDefault("B", 0.00)
                + prevC * mapC.getOrDefault("C", 0.00)
                + prevD * mapC.getOrDefault("D", 0.00);
        possibilities[3] = prevA * mapD.getOrDefault("A", 0.00)
                + prevB * mapD.getOrDefault("B", 0.00)
                + prevC * mapD.getOrDefault("C", 0.00)
                + prevD * mapD.getOrDefault("D", 0.00);
    }
}
