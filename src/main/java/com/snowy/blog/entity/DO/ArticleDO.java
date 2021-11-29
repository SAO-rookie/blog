package com.snowy.blog.entity.DO;

import com.baomidou.mybatisplus.annotation.TableName;
import com.snowy.blog.entity.BaseModel;

import java.io.Serializable;

/**
 * @author snowy
 * @date 2021/11/22 21:53
 */
@TableName("sys_article")
public class ArticleDO extends BaseModel implements Serializable {

    private Long authorId;

    private Long categoryId;

    private String introduction;

    private String title;

    private String content;

    private Integer viewCount;



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

    public Integer getViewCount() {
        return viewCount;
    }

    public void setViewCount(Integer viewCount) {
        this.viewCount = viewCount;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
