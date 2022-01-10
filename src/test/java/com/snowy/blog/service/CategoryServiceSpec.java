package com.snowy.blog.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.snowy.blog.BlogApplication;
import com.snowy.blog.common.enums.InfoJudgment;
import com.snowy.blog.entity.DTO.CategoryDTO;
import com.snowy.blog.entity.VO.CategoryVO;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * @author snowy
 * @date 2021/11/29 22:42
 */
@SpringBootTest(classes = {BlogApplication.class})
@RunWith(SpringRunner.class)
public class CategoryServiceSpec {
    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Autowired
    private CategoryService categoryService;


    @Test
    public void decideIsExist(){
        exception.expect(RuntimeException.class);
        categoryService.checkInfoIsExistById(15L, InfoJudgment.NOT_EXIST);
    }

    @Test
    public void whenCategoryInfoSaveThen() {
        Assert.assertTrue(categoryService.saveCategoryInfo("飞机"));
    }

    @Test
    public void whenCategoryInfoIsNullSaveThenProduceException() {
        exception.expect(IllegalStateException.class);
        //categoryService.saveCategoryInfo("");
        categoryService.saveCategoryInfo(null);
    }

    @Test
    public void whenCategoryInfoRepeatSaveThenProduceException(){
        categoryService.saveCategoryInfo("战士");
        exception.expect(DuplicateKeyException.class);
        categoryService.saveCategoryInfo("战士");
    }

    @Test
    public void whenUpdateCategoryInfoNotExistThenException(){
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setId(20L);
        exception.expect(RuntimeException.class);
        categoryService.updateCategoryInfoById(categoryDTO);
    }

    @Test
    public void whenUpdateCategoryInfoThenSuccess(){
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setId(1L);
        categoryDTO.setCategoryName("大炮");
        boolean b = categoryService.updateCategoryInfoById(categoryDTO);
        Assert.assertTrue(b);
    }

    @Test
    public void whenDeleteCategoryExistOtherLinkedDataThenException(){
        exception.expect(RuntimeException.class);
        categoryService.deleteCategoryById(1L);
    }


    @Test
    public void whenDeleteCategoryNotExistOtherLinkedDataThenSuccess(){
        Assert.assertTrue(categoryService.deleteCategoryById(6L));
    }

    @Test
    public void givenCategoryFirstPageDate(){
        Page<CategoryVO> categoryVOPage = categoryService.pageCategoryVOS(new Page(1, 10));
        Assert.assertTrue(categoryVOPage.getCurrent() == 1);
    }

    @Test
    public void showPageCategoryData(){
        Page<CategoryVO> categoryVOPage = categoryService.pageCategoryVOS(new Page(1, 10));
        categoryVOPage.getRecords().forEach(System.out::println);
    }



}