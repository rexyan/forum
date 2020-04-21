package com.yanrs.cloud.article.mapper;

import com.yanrs.cloud.article.bean.ArticleCollect;
import com.yanrs.cloud.article.bean.ArticleCollectExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ArticleCollectMapper {
    long countByExample(ArticleCollectExample example);

    int deleteByExample(ArticleCollectExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ArticleCollect record);

    int insertSelective(ArticleCollect record);

    List<ArticleCollect> selectByExample(ArticleCollectExample example);

    ArticleCollect selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ArticleCollect record, @Param("example") ArticleCollectExample example);

    int updateByExample(@Param("record") ArticleCollect record, @Param("example") ArticleCollectExample example);

    int updateByPrimaryKeySelective(ArticleCollect record);

    int updateByPrimaryKey(ArticleCollect record);
}