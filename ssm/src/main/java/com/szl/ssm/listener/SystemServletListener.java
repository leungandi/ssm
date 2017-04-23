package com.szl.ssm.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Application Lifecycle Listener implementation class SystemServletListener
 *
 */
public class SystemServletListener implements ServletContextListener {
	protected Logger logger = LoggerFactory.getLogger(SystemServletListener.class);
    /**
     * Default constructor. 
     */
    public SystemServletListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
    	ServletContext sc = sce.getServletContext();
        logger.info("系统初始化contextInitialized");
        int test = 1000;
        sc.setAttribute("test", test);
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    	 System.out.println("销毁contextDestroyed");
    }
	
}
