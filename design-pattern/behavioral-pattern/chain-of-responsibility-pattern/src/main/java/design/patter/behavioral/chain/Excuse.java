package design.patter.behavioral.chain;

/**
 * 请假条
 *
 * @author mexioex
 * @date 2023-06-15
 */
public class Excuse {
    private String name;
    private String content;
    private Integer Num;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getNum() {
        return Num;
    }

    public void setNum(Integer num) {
        Num = num;
    }

    public Excuse(String name, String content, Integer num) {
        this.name = name;
        this.content = content;
        Num = num;
    }
}
