package design.patter.behavioral.chain;

/**
 * 总经理处理器
 *
 * @author mexioex
 * @date 2023-06-15
 */
public class GeneralMangerHandler extends Handler {
    public GeneralMangerHandler() {
        super(Handler.NUM_THREE, Handler.NUM_SEVEN);
    }

    @Override
    protected void handleLeave(Excuse excuse) {
        System.out.println(excuse.getName() + ",请假" + excuse.getNum() + "天." + excuse.getContent());
        System.out.println("总经理审批: 同意");
    }
}
