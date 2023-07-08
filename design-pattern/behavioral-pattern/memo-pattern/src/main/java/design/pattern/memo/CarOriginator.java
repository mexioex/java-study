package design.pattern.memo;

/**
 * 汽车状态发起者
 *
 * @author mexioex
 * @date 2023-07-08
 */
public class CarOriginator {
    /**
     * 汽车状态
     */
    private String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    /**
     * 保存状态
     *
     * @return 返回备忘录
     */
    public Memento saveState() {
        return new Memento(this.state);
    }

    /**
     * 回复状态
     *
     * @param memento 回复的快照
     */
    public void restoreState(Memento memento) {
        this.state = memento.getState();
    }

    /**
     * 备忘录
     */
    public static class Memento {
        /**
         * 保存状态
         */
        private final String state;

        public String getState() {
            return state;
        }

        public Memento(String state) {
            this.state = state;
        }
    }
}
