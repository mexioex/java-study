package se.oop.base;

import java.util.Random;

/**
 * 角色类
 *
 * @author mexioex
 * @date 2023-06-11
 */
public class Role {
    private String name;
    private int healthy;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealthy() {
        return healthy;
    }

    public void setHealthy(int healthy) {
        this.healthy = healthy;
    }

    public Role() {
    }

    public Role(String name, int healthy) {
        this.name = name;
        this.healthy = healthy;
    }

    public void attack(Role role) {
        Random r = new Random();
        int hurt = r.nextInt(20) + 1;
        int remainHealthy = role.getHealthy() - hurt;
        remainHealthy = Math.max(remainHealthy, 0);
        role.setHealthy(remainHealthy);
        System.out.println(this.getName() + " 举起拳头打了," + role.getName() + ", 一下");
        System.out.println("造成了: " + hurt + " 点伤害");
        System.out.println(role.getName() + " 还剩下 " + remainHealthy + " 血量");
    }
}
