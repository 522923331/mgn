package com.tt.enums;

/**
 * @author dangwu
 * @since 2021/1/25 11:30 上午
 */
public enum StockHandlerTypeEnum {
    ORDER("ORDER","订单"),SELLER("SELLER","商家后台");
    private String code;
    private String desc;

    StockHandlerTypeEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
