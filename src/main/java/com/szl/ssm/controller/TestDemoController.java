/**
 * 
 */
package com.szl.ssm.controller;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.jsoup.helper.HttpConnection.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.szl.ssm.entity.User;
import com.szl.ssm.service.UserService;

/**
 * <p>Title:TestController</p>
 * <p>Description:</p>
 * <p>Company:MW</p>
 * @author szl
 * @date 2016年6月4日 上午11:08:18
 */
@Controller //负责注册一个bean 到spring 上下文中
@RequestMapping("/test") //注解为控制器指定可以处理哪些 URL 请求
public class TestDemoController {

	
	/**
	 * 首页
	 * @return
	 */
	@RequestMapping("hello")
	public String hello(){
		return "hello";
	}
	
	/**
	 * 文件上传
	 * @param request
	 * @return
	 */
	@RequestMapping("upload")
	public String upload(HttpServletRequest request){
		MultipartHttpServletRequest mrep = (MultipartHttpServletRequest) request;
		MultipartFile file = mrep.getFile("file");
		String fileName = file.getOriginalFilename();
		String path = request.getSession().getServletContext().getRealPath("/")+"upload/";
		String fileSuffix  = fileName.substring(fileName.indexOf("."));
		File newFile = new File(path);
		if(!newFile.exists()) newFile.mkdir();
		FileOutputStream fos=null;
		try {
			fos = new FileOutputStream(path+UUID.randomUUID()+fileSuffix);
			fos.write(file.getBytes());
			fos.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			try {
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return "hello";
	}
	/**
	 * restFul风格
	 * @param id
	 */
	@RequestMapping(value = "restful/{id}/{name}",method=RequestMethod.GET)
	public String restFul(@PathVariable("id") Integer id,@PathVariable("name") String name){
		System.out.println("id====="+id);
		System.out.println("name====="+name);
		return "hello";
	}
	
	/**
	 * 处理局部异常（controller内）
	 * @param ex
	 * @return
	 */
	@ExceptionHandler
	public ModelAndView exceptionHandler(Exception ex){
		ModelAndView mv = new ModelAndView("error");//出现异常调到error.jsp
		mv.addObject("exception", ex);
		System.out.println("error===="+ex);
		return mv;
	}
	@RequestMapping(value = "error")
	public String error(){
		int i = 1/0;
		return "hello";
	}
	
	@RequestMapping(value = "echarts")
	public String echarts(){
		return "echarts";
	}
}
