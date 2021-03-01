package com.lawliet.design.adapter;

/**
 * 充电器
 * @author dell
 */
public class Charger {

    /*
     这里假设，我们只有Type-B的充电器
     */
    private TypeBCharger typeBCharger;
    public Charger(TypeBCharger typeBCharger) {
        this.typeBCharger = typeBCharger;
    }

    public void charge() {
        this.typeBCharger.charge();
    }
}
