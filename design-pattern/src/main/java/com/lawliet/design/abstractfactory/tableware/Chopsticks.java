package com.lawliet.design.abstractfactory.tableware;

/**
 * 筷子对象
 * @author dell
 */
public class Chopsticks implements TableWare {
    @Override
    public String action() {
        return "筷子用来夹菜";
    }
}
