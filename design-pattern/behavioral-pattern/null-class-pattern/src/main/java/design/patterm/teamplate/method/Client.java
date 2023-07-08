package design.patterm.teamplate.method;

/**
 * 测试类
 *
 * @author mexioex
 * @date 2023-07-08
 */
public class Client {
    public static void main(String[] args) {
        AbstractGet getFood = new FootGet();
        AbstractGet getApple = new AppleGet();
        AbstractGet nullGet = new NullGet();
        getFood.get();
        getApple.get();
        nullGet.get();
    }
}
