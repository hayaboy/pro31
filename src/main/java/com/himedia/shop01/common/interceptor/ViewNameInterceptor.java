package com.himedia.shop01.common.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

//servlet-context���� ���ͼ��� �����س���
public class ViewNameInterceptor extends  HandlerInterceptorAdapter{
	   @Override
	   public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler){
		   try {
				String viewName = getViewName(request);
				request.setAttribute("viewName", viewName);
				System.out.println("���ͼ��Ϳ��� ���� �����"+viewName);
				System.out.println("----- ������� ���ͼ����� ����");
			} catch (Exception e) {
				e.printStackTrace();
			}
			return true;
	   }

	   @Override
	   public void postHandle(HttpServletRequest request, HttpServletResponse response,
	                           Object handler, ModelAndView modelAndView) throws Exception {
	   }

	   @Override
	   public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
	                                    Object handler, Exception ex)    throws  Exception {
	   }
	   
	   private String getViewName(HttpServletRequest request) throws Exception {
		   String contextPath = request.getContextPath();
			System.out.println(contextPath);
			String uri = (String) request.getAttribute("javax.servlet.include.request_uri");
			System.out.println(uri);
			if (uri == null || uri.trim().equals("")) {
				uri = request.getRequestURI();
			}
			System.out.println("getRequestURI()���� ������ uri:" + uri);
			int begin = 0;
			if (!((contextPath == null) || ("".equals(contextPath)))) {
				begin = contextPath.length();
			}
			System.out.println("ó�� �ε��� ��ġ(���ؽ��� �н� ����):" +begin);
			int end;
			System.out.println(";�� ��ġ, ������ -1:" + uri.indexOf(";"));
			if (uri.indexOf(";") != -1) {
				end = uri.indexOf(";");
			} else if (uri.indexOf("?") != -1) {
				end = uri.indexOf("?");
			} else {
				end = uri.length();
			}
			System.out.println("uri�� ����:"+end);
			
			String viewName = uri.substring(begin, end);
			System.out.println("���� �����"+viewName);
			
			System.out.println( "����ӿ� .�� ������ -1, ���� ������ �� ��ġ :  " +viewName.indexOf("."));
			if (viewName.indexOf(".") != -1) {
				viewName = viewName.substring(0, viewName.lastIndexOf("."));
				System.out.println("������ �������� �ִ� �κи� ������ :" + viewName);
			}
			System.out.println( "����ӿ� /�� ������ -1, ���� ������ ������ �� ��ġ :  " +viewName.lastIndexOf("/"));
			if (viewName.lastIndexOf("/") != -1) {
				viewName = viewName.substring(viewName.lastIndexOf("/",1), viewName.length());
				System.out.println(viewName);
			}
			return viewName;
	}
}