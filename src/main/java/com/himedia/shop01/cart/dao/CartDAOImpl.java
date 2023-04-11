package com.himedia.shop01.cart.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.himedia.shop01.cart.vo.CartVO;
import com.himedia.shop01.goods.vo.GoodsVO;

@Repository("cartDAO")
public class CartDAOImpl implements CartDAO{
	@Autowired
	private SqlSession sqlSession;

	@Override
	public List<CartVO> selectCartList(CartVO cartVO) throws DataAccessException {
		List<CartVO> cartList =(List)sqlSession.selectList("mapper.cart.selectCartList",cartVO);
		return cartList;
	}

	@Override
	public List<GoodsVO> selectGoodsList(List<CartVO> cartList) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean selectCountInCart(CartVO cartVO) throws DataAccessException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void insertGoodsInCart(CartVO cartVO) throws DataAccessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateCartGoodsQty(CartVO cartVO) throws DataAccessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteCartGoods(int cart_id) throws DataAccessException {
		// TODO Auto-generated method stub
		
	}
}
