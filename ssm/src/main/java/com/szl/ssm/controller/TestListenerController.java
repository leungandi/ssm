package com.szl.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sz.ssm.base.BaseController;

@Controller
@RequestMapping("test")
public class TestListenerController extends BaseController{
	
	@RequestMapping("systemServletListener")
	public String systemServletListener(){
		logger.info("开始从上下文中获取消息");
		int test = (int) request.getServletContext().getAttribute("test");
		logger.info("获取的数值是：" + test);
		return "hello";
	}
	
	/**
	 * 创建session
	 * @return
	 */
	@RequestMapping("sessionListener")
	public String sessionListener(){
		Integer count = (Integer) request.getSession().getAttribute("count");
		logger.info("目前在线人数：" + count);
		return "hello";
	}
	/**
	 * 销毁session
	 * @return
	 */
	@RequestMapping("sessionDestroyed")
	public String sessionDestroyed(){
		request.getSession().invalidate();
		return "hello";
	}

	/**
	 * 移除session
	 * @return
	 */
	@RequestMapping("attributeRemoved")
	public String attributeRemoved(){
		request.getSession().removeAttribute("count");
		Object ob = request.getSession().getAttribute("count");
		logger.info("========"+ob);
		return "hello";
	}
	
}
