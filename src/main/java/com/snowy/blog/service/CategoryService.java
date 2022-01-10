package com.snowy.blog.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.snowy.blog.common.enums.InfoJudgment;
import com.snowy.blog.entity.DO.CategoryDO;
import com.snowy.blog.entity.DTO.CategoryDTO;
import com.snowy.blog.entity.VO.CategoryVO;

/**
 * @author snowy
 * @date 2021/11/29 22:40
 */
public interface CategoryService extends IService<CategoryDO> {
    Page<CategoryVO> pageCategoryVOS(Page page);

    boolean saveCategoryInfo(String categoryName);

    boolean updateCategoryInfoById(CategoryDTO categoryDTO);

    void checkInfoIsExistById(long id, InfoJudgment infoJudgment);

    boolean deleteCategoryById(long id);
}
