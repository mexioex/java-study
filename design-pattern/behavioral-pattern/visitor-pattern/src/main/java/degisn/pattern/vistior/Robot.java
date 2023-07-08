package degisn.pattern.vistior;

/**
 * 机器人
 *
 * @author mexioex
 * @date 2023-07-08
 */
public class Robot {
    private final Cpu cpu;
    private final Disk disk;

    public Robot() {
        this.cpu = new Cpu("1+1=1");
        this.disk = new Disk("1+1=1");
    }

    /**
     * 计算
     */
    public void calculate() {
        cpu.run();
        disk.run();
    }

    public void accept(Visitor visitor) {
        cpu.accept(visitor);
        disk.accept(visitor);
    }
}
