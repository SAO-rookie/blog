package com.snowy.blog.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.google.common.base.Preconditions;
import com.snowy.blog.common.emun.State;

import java.util.Date;
import java.util.Objects;

/**
 * @author snowy
 * @date 2021/11/22 21:54
 */
public abstract class BaseModel {
    private Long id;

    private Date createTime;

    private Date updateTime;

    private State state;

    public void setId(Long id) {
        this.id = id;
    }

    public void logicDelete(){
        this.updateTime = new Date();
        this.state = State.DELETED;
    }

    public void setState(State state) {
        Preconditions.checkNotNull(state);
        this.state = state;
    }

    public void checkUpdateTime(){
        this.updateTime = new Date();
    }

    public Long getId() {
        return id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setState(Integer num) {
        this.state = State.getStateByNumber(num);
    }

    public State getState() {
        return state;
    }
}
