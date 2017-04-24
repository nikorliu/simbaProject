package com.simba.util;

import java.util.List;

import org.springframework.boot.json.JsonParserFactory;

import com.simba.framework.util.ApplicationContextUtil;

/**
 * 应用上下文中Bean关系的工具类
 * 
 * @author caozhejun
 *
 */
public class BeanUtils {

	private List<Object> beans;

	private BeanUtils() {
		init();
	}

	private static final class BeanUtilsHolder {
		private static final BeanUtils instance = new BeanUtils();
	}

	public static BeanUtils getInstance() {
		return BeanUtilsHolder.instance;
	}

	private void init() {
		HierarchyAwareLiveBeansView liveBeansView = new HierarchyAwareLiveBeansView();
		liveBeansView.setLeafContext(ApplicationContextUtil.getContext());
		beans = JsonParserFactory.getJsonParser().parseList(liveBeansView.getSnapshotAsJson());
	}

	public List<Object> list() {
		return beans;
	}
}
