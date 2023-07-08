package design.patterm.teamplate.method;

/**
 * 抽象获取方法
 *
 * @author mexioex
 * @date 2023-07-08
 */
public abstract class AbstractGet {
    public void get() {
        System.out.println("我要吃东西");
        String s = doGet();
        System.out.println("我在吃:" + s);
    }

    /**
     * 获取
     *
     * @return 具体实现
     */
    public abstract String doGet();
}
