package com.dili.assets.servlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dili.assets.versions.BuildVersion;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created by asiam on 2017/4/20 0020.
 */
@Component("myListener")
public class MyListener implements ServletContextListener {
	@Autowired BuildVersion buildVersion;
    /**
     * @param arg0
     * @see javax.servlet.ServletContextListener#contextDestroyed(javax.servlet.ServletContextEvent)
     */
    @Override
    public void contextDestroyed(ServletContextEvent contextEvent) {
        System.out.println("contextDestroyed...");
    }
    /**
     * @param arg0
     * @see javax.servlet.ServletContextListener#contextInitialized(javax.servlet.ServletContextEvent)
     */
    @Override
    public void contextInitialized(ServletContextEvent contextEvent) {
    	contextEvent.getServletContext().setAttribute("build", buildVersion);
        System.out.println("listener contextInitialized...");
    }
}
