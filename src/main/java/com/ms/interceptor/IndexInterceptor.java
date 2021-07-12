package com.ms.interceptor;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class IndexInterceptor extends HandlerInterceptorAdapter {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// 指向控制器时访问->要访问时调用此方法
		System.out.println("preHandle(), 在访问Controller之前被调用"); 
		return true;
		//返回false->不会执行控制器所访问的控制器
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// 访问控制器之后调用->返回mav之前
		System.out.println("postHandle(), 在访问Controller之后，访问视图之前被调用,这里可以注入一个时间到modelAndView中，用于后续视图显示");
        modelAndView.addObject("date","由拦截器生成的时间:" + new Date());
		
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// 控制器结束访问->返回mav之后调用
		System.out.println("afterCompletion(), 在访问视图之后被调用"); 
	}
}
