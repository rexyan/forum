package com.yanrs.cloud.article.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yanrs.cloud.article.service.ArticleInfoService;
import com.yanrs.cloud.common.vo.resp.AppResponse;
import com.yanrs.cloud.common.vo.resp.ArticleIndexRespVo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/article")
public class ArticleInfoController {

	@Autowired
	ArticleInfoService articleInfoService;

	/**
	 * 首页数据
	 * 
	 * @param pageIndex
	 * @param accessTime
	 * @return
	 */
	@GetMapping("/index/{pageIndex}")
	public AppResponse<Object> getArticleInfo(@PathVariable("pageIndex") Integer pageIndex) {
		// 分页信息
		PageHelper.startPage(pageIndex, 15);
		// 获取热门数据
		List<ArticleIndexRespVo> articles = articleInfoService.getHotArticleInfo();
		return AppResponse.success(articles);
	}
}
