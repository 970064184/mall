package com.mall.base.constant;

/**
 * Description: 是否可用状态枚举
 *
 * @author zb
 * @date 2020/5/18 19:29
 */
public enum AvailableOrNotEnum {

    ENABLED(1),//启用
    DISABLED(0);//禁用

    private int status;

    AvailableOrNotEnum() {
    }
    AvailableOrNotEnum(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

}
