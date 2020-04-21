package com.yanrs.cloud.article.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageInfo;
import com.yanrs.cloud.article.bean.Article;
import com.yanrs.cloud.article.mapper.ArticleCommentMapper;
import com.yanrs.cloud.article.mapper.ArticleLikeMapper;
import com.yanrs.cloud.article.mapper.ArticleMapper;
import com.yanrs.cloud.article.mapper.ArticleViewMapper;
import com.yanrs.cloud.article.service.ArticleInfoService;
import com.yanrs.cloud.common.vo.resp.ArticleIndexRespVo;

@Service
public class ArticleInfoServiceImpl implements ArticleInfoService {
	@Autowired
	ArticleMapper articleMapper;
	
	@Autowired
	ArticleLikeMapper articleLikeMapper;
	
	@Autowired
	ArticleCommentMapper articleCommentMapper;
	
	@Autowired
	ArticleViewMapper articleViewMapper;
	
	@Override
	public List<ArticleIndexRespVo> getHotArticleInfo() {
		ArrayList<ArticleIndexRespVo> articleIndexArrayList = new ArrayList<ArticleIndexRespVo>();
		
		// 按照时间排序获取文章信息
		List<Article> listaArticle = articleMapper.getArticleInfoOrderByUpdateAt();
		// 分页
		PageInfo<Article> articlesPageInfo = new PageInfo<>(listaArticle);
		List<Article> articleList = articlesPageInfo.getList();
		for (Article article : articleList) {
			// 查询文章评论条数总数
			int commontCount = articleCommentMapper.getArticleCommontCount(article.getId());
			// 查询文章点赞总数
			int likeCount = articleLikeMapper.getArticleLikeCount(article.getId());
			// 查询文章浏览次数总数
			int viewCount = articleViewMapper.getArticleViewCount(article.getId());
		
			ArticleIndexRespVo articleIndexRespVo = new ArticleIndexRespVo();
			BeanUtils.copyProperties(article, articleIndexRespVo);
			
			articleIndexRespVo.setCommontCount(commontCount);
			articleIndexRespVo.setLikeCount(likeCount);
			articleIndexRespVo.setViewCount(viewCount);
			
			articleIndexArrayList.add(articleIndexRespVo);
		}
		return articleIndexArrayList;
	}
}
