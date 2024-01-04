package com.cafe.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

// 인터셉터에서 잡은 url 주소에 대한 처리
public class AuthenticationInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		// 인터셉터에서 잡는다.
		HttpSession session=request.getSession();
		Object obj = session.getAttribute("userid");
		if(obj==null) {
			response.sendRedirect(request.getContextPath()+"/");
			return false;
		}	
		
		return super.preHandle(request, response, handler);  // 원래 url로 가거라..
	}

}
