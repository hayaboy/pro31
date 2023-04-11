package com.himedia.shop01.main;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.himedia.shop01.common.base.BaseController;
import com.himedia.shop01.goods.service.GoodsService;
import com.himedia.shop01.goods.vo.GoodsVO;


/* 
 * @EnableAspectJAutoProxy�� ������ �����ӿ�ũ���� AOP�� �����ϴ� ��� �� �ϳ��Դϴ�. �� ������̼��� ����ϸ� Spring AOP�� ����� �� ������, ���Ͻ� ��� AOP�� �����ϴ� �� ���˴ϴ�.
@EnableAspectJAutoProxy ������̼��� ������ ���� ������ �����մϴ�.
AspectJ ���Ͻø� Ȱ��ȭ: @EnableAspectJAutoProxy�� ����ϸ� AspectJ ���Ͻø� Ȱ��ȭ �� �� �ֽ��ϴ�. �� ���Ͻô� Spring AOP���� ���Ǹ�, �޼ҵ� ȣ�� ���� ���� ����Ʈ���� AOP�� ������ �� �ֽ��ϴ�.
AOP Proxy Bean ����: @EnableAspectJAutoProxy�� ����ϸ� Spring�� AOP ���Ͻ� ���� �����մϴ�. �� ���� �ֽ���Ʈ�� ����Ͽ� �� �޼ҵ� ȣ���� ���Ͻ�ȭ�մϴ�. �̸� ���� Ⱦ�� ���ɻ�(cross-cutting concern)�� ���� ������ �� �ֽ��ϴ�.
�����̽�(Advice) ����: @EnableAspectJAutoProxy�� AOP ���Ͻ� ���� �����ϰ�, �̸� ���� �ֽ���Ʈ�� �����մϴ�. �ֽ���Ʈ�� �����̽�(Advice)�� �����ϸ�, �����̽��� ���� ����Ʈ�� ����Ǵ� �ڵ带 �����մϴ�.
���Ͻ� ��ü ����: @EnableAspectJAutoProxy�� Spring�� ���Ͻ� ��ü�� �����ϰ�, ���� ��ü�� ��ü�ϴ� �� ���˴ϴ�. �̸� ���� AOP ���Ͻø� �����ϰ�, ���Ͻ� ��ü�� ����Ͽ� �޼ҵ� ȣ�� ���� ���� ����Ʈ���� �ֽ���Ʈ�� ������ �� �ֽ��ϴ�.
 * 
 * 
 * */
@Controller("mainController")
@EnableAspectJAutoProxy // Enables support for handling components marked with AspectJ's @Aspect annotation,similar to functionality found in Spring's <aop:aspectj-autoproxy> XML element. 
public class MainController extends BaseController {
	
	@Autowired
	private GoodsService goodsService;

	@RequestMapping(value= "/main/main.do" ,method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView main(HttpServletRequest request, HttpServletResponse response) throws Exception{
		HttpSession session;
		
		ModelAndView mav=new ModelAndView();
		String viewName=(String)request.getAttribute("viewName");
		mav.setViewName(viewName);
		
		session=request.getSession();
		// ����ڿ� ���� �޴��� ������ �޶���
		session.setAttribute("side_menu", "user");
		Map<String,List<GoodsVO>> goodsMap=goodsService.listGoods();
		
		mav.addObject("goodsMap", goodsMap);
		return mav;
	}
	
	
	
	
	
	
	
	
}
