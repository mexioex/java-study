package design.pattern.creational.builder.chain;

/**
 * 手机类
 *
 * @author mexioex
 * @date 2023-06-10
 */
public class Phone {
    private String cpu;
    private String screen;
    private String memory;
    private String motherBoard;

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getScreen() {
        return screen;
    }

    public void setScreen(String screen) {
        this.screen = screen;
    }

    public String getMemory() {
        return memory;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }

    public String getMotherBoard() {
        return motherBoard;
    }

    public void setMotherBoard(String motherBoard) {
        this.motherBoard = motherBoard;
    }

    private Phone(Builder builder) {
        this.cpu = builder.cpu;
        this.screen = builder.screen;
        this.memory = builder.memory;
        this.motherBoard = builder.motherBoard;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "cpu='" + cpu + '\'' +
                ", screen='" + screen + '\'' +
                ", memory='" + memory + '\'' +
                ", motherBoard='" + motherBoard + '\'' +
                '}';
    }

    static final class Builder {
        private String cpu;
        private String screen;
        private String memory;
        private String motherBoard;

        public Builder cpu(String cpu) {
            this.cpu = cpu;
            return this;
        }

        public Builder screen(String screen) {
            this.screen = screen;
            return this;
        }

        public Builder memory(String memory) {
            this.memory = memory;
            return this;
        }

        public Builder motherBoard(String motherBoard) {
            this.motherBoard = motherBoard;
            return this;
        }

        public Phone build() {
            return new Phone(this);
        }
    }
}
