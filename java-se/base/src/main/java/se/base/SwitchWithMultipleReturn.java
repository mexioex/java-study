package se.base;

import java.util.Scanner;

/**
 * switch 中多条语句再返回值
 *
 * @author mexioex
 * @date 2023-06-09
 */
public class SwitchWithMultipleReturn {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        String s = switch (i) {
            case 1 -> {
                System.out.println("今天是周一");
                yield "周一";
            }
            case 2 -> {
                System.out.println("今天是周二");
                yield "周二";
            }
            case 3 -> {
                System.out.println("今天是周三");
                yield "周三";
            }
            case 4 -> {
                System.out.println("今天是周四");
                yield "周四";
            }
            case 5 -> {
                System.out.println("今天是周五");
                yield "周五";
            }
            case 6 -> {
                System.out.println("今天是周六");
                yield "周六";
            }
            case 7 -> {
                System.out.println("今天是周日");
                yield "周日";
            }
            default -> {
                System.out.println("不知道今天是周几");
                yield "?";
            }
        };
        System.out.println(s);
    }
}
