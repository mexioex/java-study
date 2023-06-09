package se.base;

import java.util.Scanner;

/**
 * 箭头switch
 *
 * @author mexioex
 * @date 2023-06-09
 */
public class SwitchWithArrow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        switch (i) {
            case 1 -> System.out.println("今天是周一");
            case 2 -> System.out.println("今天是周二");
            case 3 -> System.out.println("今天是周三");
            case 4 -> System.out.println("今天是周四");
            case 5 -> System.out.println("今天是周五");
            case 6 -> System.out.println("今天是周六");
            case 7 -> System.out.println("今天是周日");
            default -> System.out.println("不知道今天是周几");
        }
    }
}
