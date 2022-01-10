package com.snowy.blog.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.base.Preconditions;
import com.snowy.blog.common.enums.InfoJudgment;
import com.snowy.blog.common.enums.State;
import com.snowy.blog.common.tools.BeanUtils;
import com.snowy.blog.entity.DO.CategoryDO;
import com.snowy.blog.entity.DTO.CategoryDTO;
import com.snowy.blog.entity.VO.CategoryVO;
import com.snowy.blog.mapper.CategoryMapper;
import com.snowy.blog.service.ArticleService;
import com.snowy.blog.service.CategoryService;
import org.apache.commons.lang3.StringUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author snowy
 * @date 2021/11/29 22:41
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, CategoryDO> implements CategoryService {

    private ArticleService articleService;

    @Autowired
    public void setArticleService(ArticleService articleService) {
        this.articleService = articleService;
    }


    @Override
    public Page<CategoryVO> pageCategoryVOS(Page page) {
        Page doPage = this.lambdaQuery().page(page);
        List list = BeanUtils.mapAsList(doPage.getRecords(), CategoryVO.class);
        doPage.setRecords(list);
        return doPage;
    }

    @Override
    public boolean saveCategoryInfo(String categoryName) {
        Preconditions.checkState(StringUtils.isNoneBlank(categoryName));
        CategoryDO categoryDO = new CategoryDO();
        categoryDO.setCategoryName(categoryName.trim());
        return this.save(categoryDO);
    }

    @Override
    public boolean updateCategoryInfoById(CategoryDTO categoryDTO) {
        this.checkInfoIsExistById(categoryDTO.getId(),InfoJudgment.NOT_EXIST);
        CategoryDO categoryDO = BeanUtils.map(categoryDTO, CategoryDO.class);
        categoryDO.checkUpdateTime();
        return this.updateById(categoryDO);
    }



    @Override
    public void checkInfoIsExistById(long id, InfoJudgment infoJudgment) {
        Integer count = lambdaQuery().eq(CategoryDO::getId, id).eq(CategoryDO::getState, State.NOT_DELETE).count();
        InfoJudgment.handlerInfoJudgment(count,infoJudgment,"类别");
    }

    @Override
    public boolean deleteCategoryById(long id) {
        articleService.checkInfoIsExistByCategoryId(id,InfoJudgment.EXIST);
        return removeById(id);
    }
}
