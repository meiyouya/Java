package com.lawliet.design.factory;

/**
 * 创建Human的工厂
 * 使用静态方法可以省去创建工厂对象的步骤，这种方式被称为静态工厂模式
 * @author dell
 */
public class HumanFactory {

    /**
     * 根据性别创建Human对象
     * 普通的工厂模式根据传入的一个类型，返回不同的对象
     * 但是如果传入的类型出错，就不能正确创建对象
     * 可以通过多工厂方法模式来确保每次都可以正确的创建对象
     * @param gender 性别，male-男，female-女
     * @return Human对象
     */
    public static Human createHuman(String gender) {
        if ("male".equalsIgnoreCase(gender)) {
            return new Male();
        } else if ("female".equalsIgnoreCase(gender)) {
            return new Female();
        }
        return null;
    }

    /**
     * 将createHuman方法中的if抽取为多个方法，确保能正确创建俺对象
     * @return Male对象
     */
    public static Human createMale() {
        return new Male();
    }

    /**
     * 将createHuman方法中的if抽取为多个方法，确保能正确创建俺对象
     * @return Female对象
     */
    public static Human createFemale() {
        return new Female();
    }
}
