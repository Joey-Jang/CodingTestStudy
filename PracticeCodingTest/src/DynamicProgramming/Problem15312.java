package DynamicProgramming;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Problem15312 {
    private static Map<Character, Integer> AlphaMap;

    public Problem15312() {
        AlphaMap = new HashMap<>();
        AlphaMap.put('A', 3);
        AlphaMap.put('B', 2);
        AlphaMap.put('C', 1);
        AlphaMap.put('D', 2);
        AlphaMap.put('E', 3);
        AlphaMap.put('F', 3);
        AlphaMap.put('G', 2);
        AlphaMap.put('H', 3);
        AlphaMap.put('I', 3);
        AlphaMap.put('J', 2);
        AlphaMap.put('K', 2);
        AlphaMap.put('L', 1);
        AlphaMap.put('M', 2);
        AlphaMap.put('N', 2);
        AlphaMap.put('O', 1);
        AlphaMap.put('P', 2);
        AlphaMap.put('Q', 2);
        AlphaMap.put('R', 2);
        AlphaMap.put('S', 1);
        AlphaMap.put('T', 2);
        AlphaMap.put('U', 1);
        AlphaMap.put('V', 1);
        AlphaMap.put('W', 1);
        AlphaMap.put('X', 2);
        AlphaMap.put('Y', 2);
        AlphaMap.put('Z', 1);
    }

    public static void main(String[] args) {
        new Problem15312();

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter my name : ");
        String myName = sc.nextLine();
        System.out.print("Enter your name : ");
        String yourName = sc.nextLine();

        System.out.printf("%02d", calcComp(myName, yourName));
    }

    public static Integer calcComp(String myName, String yourName) {
        String comp;

        StringBuffer sb = new StringBuffer();
        for(int i=0; i<myName.length(); i++) {
            sb.append(AlphaMap.get(myName.charAt(i)));
            sb.append(AlphaMap.get(yourName.charAt(i)));
        }
        comp = sb.toString();

        while(comp.length() > 2) {
            sb.setLength(0);
            for(int i=0; i<comp.length()-1; i++) {
                sb.append( ((comp.charAt(i)-'0') + (comp.charAt(i+1)-'0')) % 10 );
            }
            comp = sb.toString();
        }

        return Integer.parseInt(comp);
    }
}
