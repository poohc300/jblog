package com.douzone.jblog.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.douzone.jblog.vo.UserVo;

public class AuthInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(
		HttpServletRequest request,
		HttpServletResponse response,
		Object handler)
			throws Exception {
		
		//1. handler ���� Ȯ��
		if(handler instanceof HandlerMethod == false) {
			// DefaultServletHandler�� ó���ϴ� ���(���� �ڿ� ����)
			return true;
		}
		
		//2. casting
		HandlerMethod handlerMethod = (HandlerMethod)handler;
		
		//3. Handler Method�� @Auth �޾ƿ���
		Auth auth = handlerMethod.getMethodAnnotation(Auth.class);
		
		//4. Handler Method�� @Auth�� ������ Type�� �پ� �ִ��� Ȯ���Ѵ�(����)
		if(auth == null) {
			auth = handlerMethod.getMethod().getDeclaringClass().getAnnotation(Auth.class);
		}
		
		//5. Type�̳� Method �� �� @Auth�� ������ �ȵǾ� �ִ� ���
		if(auth == null) {
			return true;
		}
		
		//6. @Auth�� �پ� �ֱ� ������ ����(Authenfication) ���� Ȯ��
		HttpSession session = request.getSession();
		if(session == null) {
			response.sendRedirect(request.getContextPath()+"/user/login");
			return false;
		}
		
		UserVo authUser = (UserVo)session.getAttribute("authUser");
		if(authUser == null) {
			response.sendRedirect(request.getContextPath()+"/user/login");
			return false;
		}
		
		return true;
	}
}