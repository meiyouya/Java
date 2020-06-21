package com.lawliet.design.chain;

/**
 * 组长处理器
 * @author dell
 */
public class GroupLeaderHandler extends AbstractLeaveHandler{

    @Override
    public boolean handler(int leaveDays) {
        if (leaveDays < 2) {
            // 小于2天，可以直接批准
            return true;
        } else {
            // 大于等于2天，需要交给下一个责任链节点处理
            if (super.nextHandler != null) {
                return super.nextHandler.handler(leaveDays);
            }
        }
        return false;
    }
}
