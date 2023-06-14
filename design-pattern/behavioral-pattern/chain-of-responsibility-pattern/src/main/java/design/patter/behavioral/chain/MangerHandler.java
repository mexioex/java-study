package design.patter.behavioral.chain;

/**
 * 经理处理器
 *
 * @author mexioex
 * @date 2023-06-15
 */
public class MangerHandler extends Handler {
    public MangerHandler() {
        super(Handler.NUM_ONE, Handler.NUM_THREE);
    }

    @Override
    protected void handleLeave(Excuse excuse) {
        System.out.println(excuse.getName() + ",请假" + excuse.getNum() + "天." + excuse.getContent());
        System.out.println("经理审批: 同意");
    }
}
