package com.zql.hutool.util;

import cn.hutool.core.util.RuntimeUtil;

import java.util.List;

/**
 * @author lawliet.L
 */
public class RuntimeUtilTest {

    public static void main(String[] args) {
        Process ipconfigProcess = RuntimeUtil.exec("ipconfig");
        System.out.println(ipconfigProcess);
        String ipconfigStr = RuntimeUtil.execForStr("ipconfig");
        System.out.println(ipconfigStr);
        List<String> ipconfigLines = RuntimeUtil.execForLines("ipconfig");
        System.out.println(ipconfigLines);
    }
}
