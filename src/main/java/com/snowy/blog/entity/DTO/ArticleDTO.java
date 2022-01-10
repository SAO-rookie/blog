package com.snowy.blog.entity.DTO;

import com.snowy.blog.common.annotationp.First;
import com.snowy.blog.common.annotationp.Second;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

/**
 * @author snowy
 * @date 2021/11/23 21:54
 *
 * 使用分组验证
 *  First 代表 添加
 *  Second 代表 修改
 */

@Data
public class ArticleDTO {
    @Null(groups = {First.class})
    @NotNull(groups = {Second.class})
    private Long id;
    @NotNull(groups = {First.class,Second.class})
    private Long authorId;
    @NotNull(groups = {First.class,Second.class})
    private Long categoryId;

    private String introduction;

    @NotNull(groups = {First.class})
    private String title;

    private String content;


}

