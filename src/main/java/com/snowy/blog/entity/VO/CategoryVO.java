package com.snowy.blog.entity.VO;

import com.baomidou.mybatisplus.annotation.TableName;
import com.snowy.blog.entity.BaseModel;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author snowy
 * @date 2021/11/29 22:37
 */
@Data
public class CategoryVO{

    private Long id;

    private String categoryName;

    private Date createTime;

    private Date updateTime;
}
