package com.snowy.blog.entity.DO;

import com.baomidou.mybatisplus.annotation.TableName;
import com.snowy.blog.entity.BaseModel;
import lombok.Data;

import java.io.Serializable;

/**
 * @author snowy
 * @date 2021/11/29 22:37
 */
@Data
@TableName(value = "sys_category")
public class CategoryDO  extends BaseModel implements Serializable {
    private String categoryName;
}
