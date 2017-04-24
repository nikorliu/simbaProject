package com.simba.controller;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.boot.actuate.endpoint.AutoConfigurationReportEndpoint.Report;
import org.springframework.boot.actuate.endpoint.ConfigurationPropertiesReportEndpoint;
import org.springframework.boot.actuate.endpoint.EnvironmentEndpoint;
import org.springframework.boot.actuate.endpoint.HealthEndpoint;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.actuate.health.OrderedHealthAggregator;
import org.springframework.boot.autoconfigure.condition.ConditionEvaluationReport;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.simba.framework.util.ApplicationContextUtil;
import com.simba.framework.util.json.FastJsonUtil;
import com.simba.util.BeanUtils;

/**
 * 使用spring boot actuator 的 Controller
 * 
 * @author caozhejun
 *
 */
@Controller
@RequestMapping
public class ActuatorController {

	/**
	 * 获取线程活动的快照
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("/dump")
	public String dump(ModelMap model) {
		List<ThreadInfo> list = Arrays.asList(ManagementFactory.getThreadMXBean().dumpAllThreads(true, true));
		model.put("message", FastJsonUtil.toJson(list));
		return "message";
	}

	/**
	 * 描述应用程序上下文里全部用到的Bean，以及他们的关系
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("/beans")
	public String beans(ModelMap model) {
		List<Object> list = BeanUtils.getInstance().list();
		model.put("message", FastJsonUtil.toJson(list));
		return "message";
	}

	/**
	 * 提供了一份自动配置报告，记录哪些自动配置条件了，哪些没通过
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("/autoconfig")
	@Deprecated
	public String autoconfig(ModelMap model) {
		Report report = new Report(ConditionEvaluationReport.get(ApplicationContextUtil.getBeanFactory()));
		model.put("message", FastJsonUtil.toJson(report));
		return "message";
	}

	/**
	 * 描述配置属性（包括默认值）如何注入Bean
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("/configprops")
	@Deprecated
	public String configprops(ModelMap model) {
		ConfigurationPropertiesReportEndpoint ep = new ConfigurationPropertiesReportEndpoint();
		ep.setApplicationContext(ApplicationContextUtil.getContext());
		Map<String, Object> result = ep.invoke();
		model.put("message", FastJsonUtil.toJson(result));
		return "message";
	}

	/**
	 * 获取全部环境属性
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("/env")
	@Deprecated
	public String env(ModelMap model) {
		EnvironmentEndpoint ep = new EnvironmentEndpoint();
		Map<String, Object> result = ep.invoke();
		model.put("message", FastJsonUtil.toJson(result));
		return "message";
	}

	/**
	 * 报告应用程序的健康指标，这些值由HealthIndicator的实现类提供
	 * 
	 * @param model
	 * @return
	 */
	@Deprecated
	@RequestMapping("/health")
	public String health(ModelMap model) {
		HealthEndpoint ep = new HealthEndpoint(new OrderedHealthAggregator(), Collections.<String, HealthIndicator> emptyMap());
		Health health = ep.invoke();
		model.put("message", FastJsonUtil.toJson(health));
		return "message";
	}

	@Deprecated
	@RequestMapping("/info")
	public String info(ModelMap model) {

		return "message";
	}

	@Deprecated
	@RequestMapping("/mappings")
	public String mappings(ModelMap model) {

		return "message";
	}

	@Deprecated
	@RequestMapping("/metrics")
	public String metrics(ModelMap model) {

		return "message";
	}
}
