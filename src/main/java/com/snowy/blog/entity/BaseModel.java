package com.snowy.blog.entity;

import com.google.common.base.Preconditions;
import com.snowy.blog.common.enums.State;
import lombok.Data;

import java.util.Date;

/**
 * @author snowy
 * @date 2021/11/22 21:54
 */
@Data
public abstract class BaseModel {
    private Long id;

    private Date createTime;

    private Date updateTime;

    private State state;


    public void logicDelete(){
        this.updateTime = new Date();
        this.state = State.DELETED;
    }

    public void checkUpdateTime(){
        this.updateTime = new Date();
    }


    public Date getCreateTime() {
        return createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setState(State state) {
        Preconditions.checkNotNull(state);
        this.state = state;
    }

    public void setState(Integer num) {
        this.state = State.getStateByNumber(num);
    }

    public State getState() {
        return state;
    }
}
