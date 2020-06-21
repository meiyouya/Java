package com.lawliet.design.chain;

/**
 * 责任链模式测试
 * @author dell
 */
public class ChainTest {

    public static void main(String[] args) {
        GroupLeaderHandler groupLeaderHandler = new GroupLeaderHandler();
        ManagerHandler managerHandler = new ManagerHandler();
        CtoHandler ctoHandler = new CtoHandler();
        groupLeaderHandler.setNextHandler(managerHandler);
        managerHandler.setNextHandler(ctoHandler);

        System.out.println(groupLeaderHandler.handler(1));
        System.out.println(groupLeaderHandler.handler(3));
        System.out.println(groupLeaderHandler.handler(5));
        System.out.println(groupLeaderHandler.handler(7));
    }
}
