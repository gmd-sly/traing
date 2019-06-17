package com.springcloud.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.springcloud.dao.GoodsMapper;
import com.springcloud.entity.Goods;
import com.springcloud.service.GoodsService;

/**
 * ��Ʒģ�Ͳ㣺����ʵ�ֶ���Ʒģ����в����ķ���
 * 
 * @author sly
 *
 */
@Service
public class GoodsServiceImpl implements GoodsService {
	
	@Autowired
	private GoodsMapper goodsMapper;

	@Transactional
	@Override
	public Integer insert(Goods goods) {
		return this.goodsMapper.insert(goods);
	}

	@Override
	public PageInfo<Goods> select(Goods goods, Integer pageNumber) {
		//商品名称两端加%
		goods.setGoodsName("%" + goods.getGoodsName() + "%");
		//����ÿҳ����Ϣ
		PageHelper.startPage(pageNumber + 1,12);
		//��ѯ������������Ʒ��Ϣ
		List<Goods> list = this.goodsMapper.select(goods);
		//���ط�ҳ��Ϣ
		return new PageInfo<>(list);
	}

	@Transactional
	@Override
	public Integer updateGoodsById(Goods goods) {
		return this.goodsMapper.updateGoodsById(goods);
	}

	@Transactional
	@Override
	public Integer update(Goods goods) {
		return this.goodsMapper.updateByPrimaryKey(goods);
	}

	@Transactional
	@Override
	public List<Goods> selectGroup() {
		return this.goodsMapper.selectGroup();
	}

}
