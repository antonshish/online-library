package ru.homeproject.library.config;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;


public class WebConfig extends AbstractAnnotationConfigDispatcherServletInitializer {


    //метод содержит кофигурации. которые описывают beans
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] {AppConfig.class, MVCConfig.class};
    }

    //конфигурация, в которой реализован View Resolver
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] {AppConfig.class, MVCConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] {"/"};
    }
}
