package com.himedia.shop01.cart.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.himedia.shop01.cart.dao.CartDAO;
import com.himedia.shop01.cart.vo.CartVO;

@Service("cartService")
@Transactional(propagation=Propagation.REQUIRED)
public class CartServiceImpl implements CartService {

	@Autowired
	private CartDAO cartDAO;

	@Override
	public Map<String, List> myCartList(CartVO cartVO) throws Exception {
		Map<String,List> cartMap=new HashMap<String,List>();
		List<CartVO> myCartList=cartDAO.selectCartList(cartVO);
		return null;
	}

	@Override
	public boolean findCartGoods(CartVO cartVO) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void addGoodsInCart(CartVO cartVO) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean modifyCartQty(CartVO cartVO) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void removeCartGoods(int cart_id) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	
}
