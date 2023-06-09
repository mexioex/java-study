package se.base;

import java.util.Scanner;

/**
 * switch 直接返回值
 *
 * @author mexioex
 * @date 2023-06-09
 */
public class SwitchWithSingleReturn {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        String s = switch (i) {
            case 1 -> "今天是周一";
            case 2 -> "今天是周二";
            case 3 -> "今天是周三";
            case 4 -> "今天是周四";
            case 5 -> "今天是周五";
            case 6 -> "今天是周六";
            case 7 -> "今天是周日";
            default -> "不知道今天是周几";
        };
        System.out.println(s);
    }
}
