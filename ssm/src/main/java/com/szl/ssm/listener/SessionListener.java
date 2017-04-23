package com.szl.ssm.listener;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.slf4j.*;

/**
 * Application Lifecycle Listener implementation class SessionListener
 *
 */
public class SessionListener implements HttpSessionListener, HttpSessionAttributeListener {
	private Logger logger = LoggerFactory.getLogger(SessionListener.class);

    /**
     * Default constructor. 
     */
    public SessionListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionAttributeListener#attributeRemoved(HttpSessionBindingEvent)
     */
    public void attributeRemoved(HttpSessionBindingEvent event)  { 
         // TODO Auto-generated method stub
    	logger.info("移除session触发attributeRemoved");
    }

	/**
     * @see HttpSessionAttributeListener#attributeAdded(HttpSessionBindingEvent)
     */
    public void attributeAdded(HttpSessionBindingEvent event)  { 
         // TODO Auto-generated method stub
    	logger.info("添加session触发attributeRemoved");
    }

	/**
     * @see HttpSessionAttributeListener#attributeReplaced(HttpSessionBindingEvent)
     */
    public void attributeReplaced(HttpSessionBindingEvent event)  { 
         // TODO Auto-generated method stub
    	logger.info("改变session触发attributeRemoved");
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent se)  { 
         // TODO Auto-generated method stub
    	logger.info("新建一个会话时候触发，也可以说是客户端第一次和服务器交互时候触发sessionCreated");
    	 //获得Servlet上下文,这是所有用户共享的数据空间
    	ServletContext sc = se.getSession().getServletContext();
    	Integer count = (Integer) sc.getAttribute("count");
    	if(count == null){
    		count = new Integer(1);
    		sc.setAttribute("count", count);
    	}else{
    		count++;
    		sc.setAttribute("count", count);
    	}
    	se.getSession().setAttribute("count", count);
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent se)  { 
         // TODO Auto-generated method stub
    	logger.info("销毁会话的时候  一般来说只有某个按钮触发进行销毁 或者配置定时销毁sessionDestroyed");
    }
	
}
