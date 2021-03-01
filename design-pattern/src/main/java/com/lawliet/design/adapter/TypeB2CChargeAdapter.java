package com.lawliet.design.adapter;

/**
 * 电源适配器
 * @author dell
 */
public class TypeB2CChargeAdapter extends TypeBCharger{

    /*
    适配器中，连接type-c的接口
     */
    private TypeCCharger typeCCharger;
    public TypeB2CChargeAdapter(TypeCCharger typeCCharger) {
        this.typeCCharger = typeCCharger;
    }

    @Override
    public void charge() {
        // 适配器内部将Type-B转发到Type-C的充电方法中
        typeCCharger.charge();
    }
}
