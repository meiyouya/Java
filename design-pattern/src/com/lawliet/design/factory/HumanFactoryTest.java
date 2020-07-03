package com.lawliet.design.factory;

/**
 * @author dell
 */
public class HumanFactoryTest {
    public static void main(String[] args) {
        /*Human male = HumanFactory.createHuman("male");
        if (null != male) {
            male.eat();
            male.sleep();
            male.work();
        }
        Human female = HumanFactory.createHuman("female");
        if (null != female) {
            female.eat();
            female.sleep();
            female.work();
        }*/

        Human male = HumanFactory.createMale();
        Human female = HumanFactory.createFemale();
        male.eat();
        male.sleep();
        male.work();
        female.eat();
        female.sleep();
        female.work();
    }
}
