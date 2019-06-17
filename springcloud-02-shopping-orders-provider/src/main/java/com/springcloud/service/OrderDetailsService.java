package com.springcloud.service;

import com.github.pagehelper.PageInfo;
import com.springcloud.entity.OrderDetails;

/**
 * 订单明细模块模型层的接口，用于定义订单明细模块的方法
 * @author sunliyan
 *
 */
public interface OrderDetailsService {
	
	/**
	 * 查询指定订单编号的订单明细信息（分页功能
	 * ）
	 * @param orderId  订单编号
	 * @param pageNumber  页数
	 * @return   返回com.github.pagehelper.PageInfo<OrderDetails>类型的实例
	 */
	public abstract PageInfo<OrderDetails> selectByOrderId(Integer orderId, Integer pageNumber);		
	

}
