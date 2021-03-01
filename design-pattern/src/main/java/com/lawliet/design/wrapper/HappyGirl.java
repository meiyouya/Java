package com.lawliet.design.wrapper;

/**
 * 开心的女孩
 * @author dell
 */
public class HappyGirl extends AbstractGirlWrapper{

    private Girl girl;

    public HappyGirl(Girl girl) {
        this.girl = girl;
    }

    @Override
    public String getDesc() {
        return this.girl.getDesc() + "-快乐女孩";
    }
}
