package se.base;

import java.util.Scanner;

/**
 * 基础switch
 *
 * @author mexioex
 * @date 2023-06-09
 */
public class Switch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        switch (i) {
            case 1:
                System.out.println("今天是周一");
                break;
            case 2:
                System.out.println("今天是周二");
                break;
            case 3:
                System.out.println("今天是周三");
                break;
            case 4:
                System.out.println("今天是周四");
                break;
            case 5:
                System.out.println("今天是周五");
                break;
            case 6:
                System.out.println("今天是周六");
                break;
            case 7:
                System.out.println("今天是周日");
                break;
            default:
                System.out.println("不知道今天是周几");
                break;
        }
    }
}
