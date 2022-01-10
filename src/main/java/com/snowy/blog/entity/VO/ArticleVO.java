package com.snowy.blog.entity.VO;

import com.snowy.blog.common.annotationp.First;
import com.snowy.blog.common.annotationp.Second;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.util.Date;

/**
 * @author snowy
 * @date 2021/11/23 21:54
 */

@Data
public class ArticleVO {

    private Long id;

    private String authorName;

    private String categoryName;

    private String introduction;

    private String title;

    private String content;

    private Date createTime;

    private Date updateTime;

}

