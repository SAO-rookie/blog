package com.snowy.blog.common.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.google.common.base.Preconditions;

/**
 * @author snowy
 * @date 2021/11/22 21:58
 */
public enum State {
    NOT_DELETE(0,"未删除"),
    DELETED(1,"已删除");

    @EnumValue
    private final int code;

    private final String value;

    State(int code, String value) {
        this.code = code;
        this.value = value;
    }


    public int getCode() {
        return code;
    }

    public String getValue() {
        return value;
    }

    public static State getStateByNumber(Integer num){
        Preconditions.checkNotNull(num);
        for (State state : State.values()) {
            if (state.code == num){
                return state;
            }
        }
        throw new RuntimeException("匹配失败");
    }
}
