package com.springcloud.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.springcloud.entity.Goods;

/**
 * ��Ʒģ�Ͳ㣺���ڶ������Ʒģ����в����ķ���
 * 
 * @author sly
 *
 */
public interface GoodsService {

	/**
	 * 录入商品信息
	 * 
	 * @param goods 商品信息
	 * @return 
	 */
	public abstract Integer insert(Goods goods);

	/**
	 * 查询满足条件的商品信息（分页功能）
	 * 
	 * @param goods      查询条件
	 * @param pageNumber 页数
	 * @return  成功返回com.github.pagehelper.PageInfo<Goods>类型的实例，否则返回null
	 */
	public abstract PageInfo<Goods> select(Goods goods, Integer pageNumber);

	/**
	 *根据条件修改商品信息
	 * 
	 * @param goods 修改商品信息
	 * @return 成功返回大于0的整数，否则返回大于等于0的整数
	 */
	public abstract Integer updateGoodsById(Goods goods);

	/**
	 * 修改指定编号的商品信息
	 * 
	 * @param goods  修改的商品信息
	 * @return  成功返回大于0的整数，否则返回大于等于0的整数
	 */
	public abstract Integer update(Goods goods);

	/**
	 * 查询销量前10的商品信息
	 * 
	 * @return 成功返回java.util.list类型的实例，否则返回null
	 */
	public abstract List<Goods> selectGroup();

}
