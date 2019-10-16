package com.lawliet.json.bean;

/**
 * @author lawliet.L
 */
public enum TokenType {

    // JSON开始
    BEGIN_OBJECT(1),
    // JSON结束
    END_OBJECT(2),
    // 数组开始
    BEGIN_ARRAY(4),
    // 数组结束
    END_ARRAY(8),
    // null
    NULL(16),
    // 数字
    NUMBER(32),
    // 字符串
    STRING(64),
    // 逻辑性
    BOOLEAN(128),
    // 冒号
    SEP_COLON(256),
    // 逗号
    SEP_COMMA(512),
    // 文档结束
    END_DOCUMENT(1024);

    /**
     * @param code token类型编码
     */
    TokenType(int code) {
        this.code = code;
    }

    private int code;

    public int getCode() {
        return code;
    }
}
