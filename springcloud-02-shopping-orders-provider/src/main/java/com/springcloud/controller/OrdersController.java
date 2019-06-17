package com.springcloud.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.springcloud.common.PageUtils;
import com.springcloud.entity.Orders;
import com.springcloud.service.OrdersService;
import com.springcloud.vo.ResultValue;

/**
 * ����ģ��Ŀ��Ʋ�
 * 
 * @author sunliyan
 *
 */
@RestController
@RequestMapping("orders")
public class OrdersController {

	@Autowired
	private OrdersService ordersService;

	@RequestMapping(value = "/selectOrders")
	public ResultValue selectOrders(Orders orders, @RequestParam("pageNumber") Integer pageNumber) {
		ResultValue rv = new ResultValue();

		try {
			PageInfo<Orders> pageInfo = this.ordersService.selectOrders(orders, pageNumber);
			List<Orders> list = pageInfo.getList();
			if (list != null && list.size() > 0) {
				rv.setCode(0);
				Map<String, Object> map = new HashMap<>();
				map.put("ordersList", list);

				PageUtils pageUtils = new PageUtils(pageInfo.getPages() * PageUtils.PAGE_ROW_COUNT);
				pageUtils.setPageNumber(pageNumber);
				map.put("pageUtils", pageUtils);

				rv.setDataMap(map);
				return rv;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		rv.setCode(1);
		return rv;

	}

	/**
	 * 修改指定编号订单的订单状态
	 * 
	 * @param orders 修改的订单信息
	 * @return
	 */
	@RequestMapping(value = "/updateOrderStatus")
	public ResultValue updateOrdersStatus(Orders orders) {
		ResultValue rv = new ResultValue();

		try {
			Integer ordersStatus = this.ordersService.updateOrdersStatus(orders);
			if (ordersStatus > 0) {
				rv.setCode(0);
				rv.setMessage("订单状态修改成功！！！！");
				return rv;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		rv.setCode(1);
		rv.setMessage("订单状态修改失败！！！！");
		return rv;
	}

	/**
	 * 查询指定时间范围内的销售额
	 * 
	 * @param orders 查询条件
	 * @return
	 */
	@RequestMapping(value = "/selectGroup")
	public ResultValue selectGroup(Orders orders) {
		ResultValue rv = new ResultValue();

		try {
			List<Orders> list = this.ordersService.selectGroup(orders);
			if (list != null && list.size() > 0) {
				// 设置状态：状态为0
				rv.setCode(0);
				// 将集合分为两个集合
				List<String> x = new ArrayList<>();
				List<Double> y = new ArrayList<>();
				for (Orders o : list) {
					x.add(o.getOrderMonth());
					y.add(o.getOrderPrice());
				}
				Map<String, Object> map = new HashMap<>();
				map.put("x", x);
				map.put("y", y);
				rv.setDataMap(map);

				return rv;

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		rv.setCode(1);
		return rv;
	}

}
