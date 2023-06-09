package se.base;

/**
 * for 循环
 *
 * @author mexioex
 * @date 2023-06-09
 */
public class DoWhileLoop {
    public static void main(String[] args) {
        int i = 0;
        do {
            System.out.println("第 " + i + " 循环");
            i++;
        } while (i < 10);
    }
}
