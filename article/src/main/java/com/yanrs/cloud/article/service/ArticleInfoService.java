package com.yanrs.cloud.article.service;

import java.util.List;

import com.yanrs.cloud.common.vo.resp.ArticleIndexRespVo;

public interface ArticleInfoService {
	
	/**
	 * 首页信息
	 * @return
	 */
	List<ArticleIndexRespVo> getHotArticleInfo();

}
