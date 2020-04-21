package com.yanrs.cloud.article.mapper;

import com.yanrs.cloud.article.bean.ArticleView;
import com.yanrs.cloud.article.bean.ArticleViewExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ArticleViewMapper {
    long countByExample(ArticleViewExample example);

    int deleteByExample(ArticleViewExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ArticleView record);

    int insertSelective(ArticleView record);

    List<ArticleView> selectByExample(ArticleViewExample example);

    ArticleView selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ArticleView record, @Param("example") ArticleViewExample example);

    int updateByExample(@Param("record") ArticleView record, @Param("example") ArticleViewExample example);

    int updateByPrimaryKeySelective(ArticleView record);

    int updateByPrimaryKey(ArticleView record);

	int getArticleViewCount(Integer id);
}