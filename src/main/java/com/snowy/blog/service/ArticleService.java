package com.snowy.blog.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.snowy.blog.common.enums.InfoJudgment;
import com.snowy.blog.entity.DO.ArticleDO;
import com.snowy.blog.entity.DTO.ArticleDTO;
import com.snowy.blog.entity.VO.ArticleVO;

/**
 * @author snowy
 * @date 2021/11/22 23:04
 */
public interface ArticleService extends IService<ArticleDO> {
    boolean saveArticleInfo(ArticleDTO articleDTO);

    boolean updateArticleInfoById(ArticleDTO articleDTO);

    ArticleVO getArticleVOById(long id);

    Page<ArticleVO> pageArticleVOS(Page page);

    boolean logicDeleteById(long id);

    void checkInfoIsExistById(long id, InfoJudgment infoJudgment);

    void checkInfoIsExistByCategoryId(long categoryId, InfoJudgment infoJudgment);
}
