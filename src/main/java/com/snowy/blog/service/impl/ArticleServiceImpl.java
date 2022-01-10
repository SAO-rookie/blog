package com.snowy.blog.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.snowy.blog.common.enums.InfoJudgment;
import com.snowy.blog.common.enums.State;
import com.snowy.blog.common.tools.BeanUtils;
import com.snowy.blog.entity.DO.ArticleDO;
import com.snowy.blog.entity.DTO.ArticleDTO;
import com.snowy.blog.entity.VO.ArticleVO;
import com.snowy.blog.mapper.ArticleMapper;
import com.snowy.blog.service.ArticleService;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author snowy
 * @date 2021/11/22 23:05
 */
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, ArticleDO> implements ArticleService {
    @Override
    public boolean saveArticleInfo(ArticleDTO articleDTO) {
        ArticleDO articleDO = BeanUtils.map(articleDTO, ArticleDO.class);
        return this.save(articleDO);
    }

    @Override
    public boolean updateArticleInfoById(ArticleDTO articleDTO) {
        ArticleDO articleDO = BeanUtils.map(articleDTO, ArticleDO.class);
        articleDO.checkUpdateTime();
        return this.updateById(articleDO);
    }

    @Override
    public ArticleVO getArticleVOById(long id) {
        ArticleDO articleDO = this.getById(id);
        return BeanUtils.map(articleDO, ArticleVO.class);
    }

    @Override
    public Page<ArticleVO> pageArticleVOS(Page  page) {
        Page doPage = this.lambdaQuery().page(page);
        List list = BeanUtils.mapAsList(doPage.getRecords(), ArticleVO.class);
        doPage.setRecords(list);
        return doPage;
    }

    @Override
    public boolean logicDeleteById(long id) {
        ArticleDO articleDO = new ArticleDO();
        articleDO.setId(id);
        articleDO.logicDelete();
        return this.updateById(articleDO);
    }

    @Override
    public void checkInfoIsExistById(long id, InfoJudgment infoJudgment) {
        Integer count = lambdaQuery().eq(ArticleDO::getId, id).eq(ArticleDO::getState, State.NOT_DELETE).count();
        InfoJudgment.handlerInfoJudgment(count,infoJudgment,"文章");
    }

    @Override
    public void checkInfoIsExistByCategoryId(long categoryId, InfoJudgment infoJudgment) {
        Integer count = lambdaQuery().eq(ArticleDO::getCategoryId, categoryId).eq(ArticleDO::getState, State.NOT_DELETE).count();
        InfoJudgment.handlerInfoJudgment(count,infoJudgment,"文章");
    }

}
