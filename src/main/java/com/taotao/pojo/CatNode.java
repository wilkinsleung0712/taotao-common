package com.taotao.pojo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 查询所有商品分类生成前台页面要求的json数据格式。返回一个pojo。 需要创建两个pojo
 * 
 * @author wilkins.liang
 *
 */
public class CatNode {

	@JsonProperty("n")
	private String name;
	@JsonProperty("u")
	private String uri;
	@JsonProperty("i")
	private List<?> item;

	public CatNode(String name, String uri, List<?> item) {
		super();
		this.name = name;
		this.uri = uri;
		this.item = item;
	}

	public CatNode() {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public List<?> getItem() {
		return item;
	}

	public void setItem(List<?> item) {
		this.item = item;
	}
}
