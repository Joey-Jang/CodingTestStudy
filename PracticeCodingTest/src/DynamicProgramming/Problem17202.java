package DynamicProgramming;

import java.util.Scanner;

public class Problem17202 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first phone number: ");
        String num1 = sc.nextLine();
        System.out.print("Enter second phone number : ");
        String num2 = sc.nextLine();

        System.out.printf("%02d", calcComp(num1, num2));
    }

    public static Integer calcComp(String num1, String num2) {
        String comp;

        StringBuffer sb = new StringBuffer();
        for(int i=0; i<8; i++) {
            sb.append(num1.charAt(i));
            sb.append(num2.charAt(i));
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
