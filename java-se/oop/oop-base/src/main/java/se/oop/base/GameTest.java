package se.oop.base;

/**
 * 游戏测试类
 *
 * @author mexioex
 * @date 2023-06-11
 */
public class GameTest {
    public static void main(String[] args) {
        Role role1 = new Role("乔峰", 100);
        Role role2 = new Role("鸠摩智", 100);
        while (true) {
            role1.attack(role2);
            if (role2.getHealthy() == 0) {
                System.out.println(role1.getName() + " K.O了 " + role2.getName());
                break;
            }
            role2.attack(role1);
            if (role1.getHealthy() == 0) {
                System.out.println(role2.getName() + " K.O了 " + role1.getName());
                break;
            }
        }
    }
}
