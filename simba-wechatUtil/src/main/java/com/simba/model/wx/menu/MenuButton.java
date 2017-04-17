package com.simba.model.wx.menu;

import java.util.List;

/**
 * 自定义菜单自定义菜单按钮
 * 
 * @author caozhejun
 *
 */
public class MenuButton {

	/**
	 * 菜单标题，不超过16个字节，子菜单不超过60个字节
	 */
	private String name;

	/**
	 * 菜单的响应动作类型
	 */
	private String type;

	/**
	 * 菜单KEY值，用于消息接口推送，不超过128字节
	 */
	private String key;

	/**
	 * 调用新增永久素材接口返回的合法media_id
	 */
	private String media_id;

	/**
	 * 网页链接，用户点击菜单可打开链接，不超过1024字节
	 */
	private String url;

	/**
	 * 子菜单列表
	 */
	private List<MenuButton> sub_button;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getMedia_id() {
		return media_id;
	}

	public void setMedia_id(String media_id) {
		this.media_id = media_id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public List<MenuButton> getSub_button() {
		return sub_button;
	}

	public void setSub_button(List<MenuButton> sub_button) {
		this.sub_button = sub_button;
	}

}
