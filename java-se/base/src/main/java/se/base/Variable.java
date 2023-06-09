package se.base;

/**
 * 变量
 *
 * @author mexioex
 * @date 2023-06-08
 */
public class Variable {
    public static void main(String[] args) {
        byte aByte = 0;
        System.out.println("aByte is: " + aByte);
        short aShort = 0;
        System.out.println("aShort is: " + aShort);
        char aChar = 0;
        System.out.println("aChar is: " + aChar);
        boolean aBoolean = false;
        System.out.println("aBoolean is: " + aBoolean);
        int anInt = 0;
        System.out.println("anInt is: " + anInt);
        float aFloat = 0.1f;
        System.out.println("aFloat is: " + aFloat);
        long aLong = 0;
        float aFloat1 = aLong + aFloat;

        System.out.println("aLong is: " + (long)aFloat1);
        double aDouble = 0;
        System.out.println("aDouble is: " + aDouble);
    }
}