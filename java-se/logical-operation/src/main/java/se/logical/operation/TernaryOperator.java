package se.logical.operation;

import java.util.Scanner;

/**
 * 三元运算符
 *
 * @author mexioex
 * @date 2023-06-09
 */
public class TernaryOperator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        // a > b,result = "a>b" 否则result = "a<b"
        String result = a > b ? "a>b" : "a<b";
        System.out.println(result);
    }
}
