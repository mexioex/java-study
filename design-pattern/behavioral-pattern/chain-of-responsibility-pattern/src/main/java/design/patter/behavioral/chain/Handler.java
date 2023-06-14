package design.patter.behavioral.chain;

/**
 * 抽象处理器类
 *
 * @author mexioex
 * @date 2023-06-15
 */
public abstract class Handler {
    protected static final int NUM_ONE = 1;
    protected static final int NUM_THREE = 3;
    protected static final int NUM_SEVEN = 7;
    // 领导能够处理的天数
    private final int start;
    private int end;
    private Handler nextHandler;

    protected abstract void handleLeave(Excuse excuse);

    public final void submit(Excuse excuse) {
        handleLeave(excuse);
        if (this.nextHandler != null && excuse.getNum() > this.end) {
            this.nextHandler.submit(excuse);
        } else {
            System.out.println("流程结束");
        }
    }

    public void setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public Handler(int start) {
        this.start = start;
    }

    public Handler(int start, int end) {
        this.start = start;
        this.end = end;
    }
}
