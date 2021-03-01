package com.lawliet.design.adapter;

/**
 * 充电器适配器测试
 * @author dell
 */
public class ChargeAdapterTest {

    public static void main(String[] args) {
        /*Charger charger = new Charger(new TypeBCharger());
        charger.charge();*/

        TypeB2CChargeAdapter adapter = new TypeB2CChargeAdapter(new TypeCCharger());
        Charger charger = new Charger(adapter);
        charger.charge();
    }
}
