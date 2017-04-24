package com.simba.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.simba.framework.util.json.FastJsonUtil;

@Controller
@RequestMapping("/t")
public class TController {

	@RequestMapping
	public String jsonp(HttpServletRequest request, String info, ModelMap model) {
		Map<String, String> map = new HashMap<>();
		map.put("info", info);
		model.put("message", FastJsonUtil.toJson(map));
		request.getSession().setAttribute("info", info);
		return "message";
	}

	@RequestMapping
	public String getJsonp(HttpServletRequest request, ModelMap model) {
		String info = (String) request.getSession().getAttribute("info");
		Map<String, String> map = new HashMap<>();
		map.put("info", info);
		model.put("message", FastJsonUtil.toJson(map));
		return "message";
	}

	@RequestMapping
	public String file(ModelMap model, String info, MultipartFile file) throws IllegalStateException, IOException {
		file.transferTo(new File("D:/2.txt"));
		Map<String, String> map = new HashMap<>();
		map.put("info", info+"*******");
		model.put("message", FastJsonUtil.toJson(map));
		return "message";
	}
}
