package degisn.pattern.vistior;

/**
 * 硬件类
 *
 * @author mexioex
 * @date 2023-07-08
 */
public abstract class Hardware {
    protected String command;

    public void run() {
        System.out.println(command);
    }

    public abstract void accept(Visitor visitor);

    public Hardware(String command) {
        this.command = command;
    }
}
