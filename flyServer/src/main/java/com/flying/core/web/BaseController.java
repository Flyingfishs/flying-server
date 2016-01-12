/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.flying.core.web;

import java.beans.PropertyEditorSupport;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


/**
 * 控制器支持类
 * @author ThinkGem
 * @version 2013-3-23
 */
public abstract class BaseController {

	/**
	 * 日志对象
	 */
	protected Logger log = LoggerFactory.getLogger(getClass());

/*	*//**
	 * 管理基础路径
	 *//*
	@Value("${adminPath}")
	protected String adminPath;
	
	*//**
	 * 前端基础路径
	 *//*
	@Value("${frontPath}")
	protected String frontPath;
	
	*//**
	 * 前端URL后缀
	 *//*
	@Value("${urlSuffix}")
	protected String urlSuffix;

	*//**
	 * 添加Model消息
	 * @param message
	 *//*
	protected void addMessage(Model model, String... messages) {
		StringBuilder sb = new StringBuilder();
		for (String message : messages){
			sb.append(message).append(messages.length>1?"<br/>":"");
		}
		model.addAttribute("message", sb.toString());
	}
	
	*//**
	 * 添加Flash消息
	 * @param message
	 *//*
	protected void addMessage(RedirectAttributes redirectAttributes, String... messages) {
		StringBuilder sb = new StringBuilder();
		for (String message : messages){
			sb.append(message).append(messages.length>1?"<br/>":"");
		}
		redirectAttributes.addFlashAttribute("message", sb.toString());
	}
	*//*
	*//**//**
	 * 对象转json字符串;用于 @ResponseBody
	 * @param object
	 * @return
	 *//**//*
	protected String toJson(Object object) {
		return JsonMapper.getInstance().toJson(object);
	}
	
	*//**//**
	 * 客户端返回JSON字符串
	 * @param response
	 * @param object
	 * @return
	 *//**//*
	protected String renderString(HttpServletResponse response, Object object) {
		return renderString(response, JsonMapper.toJsonString(object), "application/json");
	}
	*//*
	*//**
	 * 客户端返回字符串
	 * @param response
	 * @param string
	 * @return
	 *//*
	protected String renderString(HttpServletResponse response, String string, String type) {
		try {
			response.reset();
	        response.setContentType(type);
	        response.setCharacterEncoding("utf-8");
			response.getWriter().print(string);
			return null;
		} catch (IOException e) {
			return null;
		}
	}*/

	
}
