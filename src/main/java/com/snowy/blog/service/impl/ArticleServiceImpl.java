package com.snowy.blog.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.base.Preconditions;
import com.snowy.blog.entity.DO.ArticleDO;
import com.snowy.blog.entity.DTO.ArticleDTO;
import com.snowy.blog.entity.VO.ArticleVO;
import com.snowy.blog.mapper.ArticleMapper;
import com.snowy.blog.service.ArticleService;
import org.springframework.beans.BeanUtils;
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
        return this.save(dtoToDo(articleDTO));
    }

    @Override
    public boolean updateArticleInfoById(ArticleDTO articleDTO) {
        ArticleDO articleDO = dtoToDo(articleDTO);
        articleDO.checkUpdateTime();
        return this.updateById(articleDO);
    }

    @Override
    public ArticleVO getArticleVOById(long id) {
        ArticleDO articleDO = this.getById(id);
        List<ArticleVO> articleVOS = batchDoToVO(Arrays.asList(articleDO));
        return articleVOS.size() > 0 ? articleVOS.stream().findFirst().get() : null;
    }

    @Override
    public Page<ArticleVO> pageArticleVO(Page  page) {
        Page<ArticleDO> doPage = this.lambdaQuery().page(page);
        Page<ArticleVO> voPage = new Page<>();
        BeanUtils.copyProperties(doPage,voPage);
        voPage.setRecords(batchDoToVO(doPage.getRecords()));
        return voPage;
    }

    @Override
    public boolean logicDeleteById(long id) {
        ArticleDO articleDO = new ArticleDO();
        articleDO.setId(id);
        articleDO.logicDelete();
        return this.updateById(articleDO);
    }

    private ArticleDO dtoToDo(ArticleDTO articleDTO){
        Preconditions.checkNotNull(articleDTO);
        ArticleDO articleDO = new ArticleDO();
        BeanUtils.copyProperties(articleDTO,articleDO);
        return articleDO;
    }

    private List<ArticleVO> batchDoToVO(List<ArticleDO> articleDOS){
        Preconditions.checkNotNull(articleDOS);
        if (articleDOS.isEmpty()){
            return Collections.emptyList();
        }
        List<ArticleVO> list = new ArrayList<>();
        for (ArticleDO articleDO : articleDOS) {
            if (Objects.nonNull(articleDO)){
                ArticleVO articleVO = new ArticleVO();
                BeanUtils.copyProperties(articleDO,articleVO);
                list.add(articleVO);
            }
        }
        return list;
    }

}
