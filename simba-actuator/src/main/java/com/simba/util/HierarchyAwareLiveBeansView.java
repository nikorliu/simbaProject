package com.simba.util;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.LiveBeansView;
import org.springframework.util.Assert;

public class HierarchyAwareLiveBeansView extends LiveBeansView {

	private ConfigurableApplicationContext leafContext;

	public void setLeafContext(ApplicationContext leafContext) {
		this.leafContext = asConfigurableContext(leafContext);
	}

	@Override
	public String getSnapshotAsJson() {
		if (this.leafContext == null) {
			return super.getSnapshotAsJson();
		}
		return generateJson(getContextHierarchy());
	}

	private ConfigurableApplicationContext asConfigurableContext(ApplicationContext applicationContext) {
		Assert.isTrue(applicationContext instanceof ConfigurableApplicationContext, "'" + applicationContext + "' does not implement ConfigurableApplicationContext");
		return (ConfigurableApplicationContext) applicationContext;
	}

	private Set<ConfigurableApplicationContext> getContextHierarchy() {
		Set<ConfigurableApplicationContext> contexts = new LinkedHashSet<ConfigurableApplicationContext>();
		ApplicationContext context = this.leafContext;
		while (context != null) {
			contexts.add(asConfigurableContext(context));
			context = context.getParent();
		}
		return contexts;
	}
}
