package com.snowy.blog.entity.DTO;

import com.snowy.blog.common.annotationp.First;
import com.snowy.blog.common.annotationp.Second;
import com.snowy.blog.common.emun.State;

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


    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}

