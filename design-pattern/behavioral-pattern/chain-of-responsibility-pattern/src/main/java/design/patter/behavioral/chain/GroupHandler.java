package design.patter.behavioral.chain;

/**
 * 组处理器
 *
 * @author mexioex
 * @date 2023-06-15
 */
public class GroupHandler extends Handler {
    public GroupHandler() {
        super(0, Handler.NUM_ONE);
    }

    @Override
    protected void handleLeave(Excuse excuse) {
        System.out.println(excuse.getName() + ",请假" + excuse.getNum() + "天." + excuse.getContent());
        System.out.println("小组长审批: 同意");
    }
}
