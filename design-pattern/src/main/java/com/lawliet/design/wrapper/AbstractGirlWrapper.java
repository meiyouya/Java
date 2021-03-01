package com.lawliet.design.wrapper;

/**
 * 女孩装饰器
 * 可以支持在不同情况下得到不同类型的女孩
 * 而且不会影响的原先的女孩对象
 * @author dell
 */
public abstract class AbstractGirlWrapper extends Girl{

    protected AbstractGirlWrapper(String desc) {
        super(desc);
    }

    protected AbstractGirlWrapper() {
    }

    /**
     * 获取女孩的类型
     * @return 类型描述
     */
    @Override
    public abstract String getDesc();
}
