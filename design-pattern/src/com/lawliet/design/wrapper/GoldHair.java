package com.lawliet.design.wrapper;

/**
 * @author dell
 */
public class GoldHair extends AbstractGirlWrapper{

    private Girl girl;

    public GoldHair(Girl girl) {
        this.girl = girl;
    }

    @Override
    public String getDesc() {
        return this.girl.getDesc() + "-金色的头发";
    }
}
