package com.lawliet.design.chain;

/**
 * CTO处理器
 * @author dell
 */
public class CtoHandler extends AbstractLeaveHandler{

    @Override
    public boolean handler(int leaveDays) {
        if (leaveDays < 7) {
            // 小于7天，可以直接批准
            return true;
        } else {
            // 大于等于7天，需要交给下一个责任链节点处理
            if (super.nextHandler != null) {
                return super.nextHandler.handler(leaveDays);
            }
        }
        return false;
    }
}
