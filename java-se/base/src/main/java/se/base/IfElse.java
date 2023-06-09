package se.base;

import java.util.Scanner;

/**
 * 条件控制语句-1
 *
 * @author mexioex
 * @date 2023-06-09
 */
public class IfElse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        // 如果 i = 1 就输出 i,否则输出我不是
        if (i == 1) {
            System.out.println(i);
        } else {
            System.out.println("我不是");
        }
    }
}
