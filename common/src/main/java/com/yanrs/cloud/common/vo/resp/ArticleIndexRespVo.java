package com.yanrs.cloud.common.vo.resp;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@ApiModel
public class ArticleIndexRespVo implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty("文章  ID")
	private Integer id;
	
	@ApiModelProperty("文章创建时间")
    private Date createAt;
	
	@ApiModelProperty("文章更新时间")
    private Date updateAt;
	
	@ApiModelProperty("文章创建人")
    private String userName;

	@ApiModelProperty("文章标题")
    private String title;
	
	@ApiModelProperty("文章类型列表")
    private List<String> typeName = new ArrayList<>();
    
	@ApiModelProperty("文章访问次数")
    private Integer viewCount;
    	
	@ApiModelProperty("文章评论次数")
    private Integer commontCount;
    
	@ApiModelProperty("文章收藏次数")
    private Integer likeCount;
}
