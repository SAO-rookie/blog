package com.snowy.blog.service;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.snowy.blog.BlogApplication;
import com.snowy.blog.common.enums.InfoJudgment;
import com.snowy.blog.entity.DTO.ArticleDTO;
import com.snowy.blog.entity.VO.ArticleVO;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author snowy
 * @date 2021/11/22 23:07
 */
@SpringBootTest(classes = {BlogApplication.class})
@RunWith(SpringRunner.class)
public class ArticleServiceSpec {
    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Autowired
    private ArticleService articleService;


    @Test
    public void whenUserSaveArticleSuccess(){
        ArticleDTO articleDTO = new ArticleDTO();
        articleDTO.setCategoryId(3L);
        articleDTO.setAuthorId(18L);
        articleDTO.setTitle("rtesdf");
        articleDTO.setIntroduction("ghbvcbcv");
        articleDTO.setContent("werwq");
        Assert.assertTrue(articleService.saveArticleInfo(articleDTO));
    }

    @Test
    public void whenArticleDTOIsNullThenException(){
        exception.expect(RuntimeException.class);
        articleService.saveArticleInfo(null);
    }

    @Test
    public void whenUserUpdateArticleSuccess(){
        ArticleDTO articleDTO = new ArticleDTO();
        articleDTO.setId(1465322607045996545L);
        articleDTO.setContent("dasdasd");
        Assert.assertTrue(articleService.updateArticleInfoById(articleDTO));
    }


    @Test
    public void whenUserGetArticleVOById(){
        ArticleVO articleVO = articleService.getArticleVOById(1463156408107270146L);
        Assert.assertNotNull(articleVO);
    }


    @Test
    public void  whenUserPageQueryCantNotNull(){
        Page<ArticleVO> articleVO = articleService.pageArticleVOS(new Page<>(1,5));
        Assert.assertTrue(articleVO.getRecords().size() > 0);
    }


    @Test
    public void whenLogicDeleteThenArticleInfoExist(){
        articleService.logicDeleteById(1465322688180600834L);
        Assert.assertNotNull(articleService.getById(1465322688180600834L));
    }

    @Test
    public void whenPhysicsDeleteThenArticleInfoNotExist(){
        articleService.removeById(1465322688180600834L);
        Assert.assertNull(articleService.getById(1465322688180600834L));
    }

    @Test
    public void checkArticleInfoIsNullThenException(){
        exception.expect(RuntimeException.class);
        articleService.checkInfoIsExistById(14631564081072701L, InfoJudgment.NOT_EXIST);
    }

    @Test
    public void checkArticleInfoNotNullThenException(){
        exception.expect(RuntimeException.class);
        articleService.checkInfoIsExistById(1463156408107270146L, InfoJudgment.EXIST);
    }


}