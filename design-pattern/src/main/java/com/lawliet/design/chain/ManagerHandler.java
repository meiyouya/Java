package com.lawliet.design.chain;

/**
 * 经理处理器
 * @author dell
 */
public class ManagerHandler extends AbstractLeaveHandler{

    @Override
    public boolean handler(int leaveDays) {
        if (leaveDays < 5) {
            // 小于5天，经理可以直接批准
            return true;
        } else {
            // 大于等于5天，需要交给下一个责任链节点处理
            if (super.nextHandler != null) {
                return super.nextHandler.handler(leaveDays);
            }
        }
        return false;
    }
}
