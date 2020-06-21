package com.lawliet.design.chain;

/**
 * 请假处理器
 * @author dell
 */
public abstract class AbstractLeaveHandler {

    /**
     * 责任链结构中的下一个处理器
     */
    protected AbstractLeaveHandler nextHandler;

    public void setNextHandler(AbstractLeaveHandler handler) {
        this.nextHandler = handler;
    }

    /**
     * 处理请假
     * @param leaveDays 请假天数
     */
    public abstract boolean handler(int leaveDays);
}
