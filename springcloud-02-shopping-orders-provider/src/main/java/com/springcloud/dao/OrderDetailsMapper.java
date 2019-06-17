package com.springcloud.dao;

import com.springcloud.entity.OrderDetails;
import java.util.List;

public interface OrderDetailsMapper {
    int deleteByPrimaryKey(Integer orderDetailId);

    int insert(OrderDetails record);

    OrderDetails selectByPrimaryKey(Integer orderDetailId);

    List<OrderDetails> selectAll();

    int updateByPrimaryKey(OrderDetails record);
    
    /**
              * 查询订单编号的订单明细信息
     * @param orderId  订单编号
     * @return   成功返回java.util.List类型的实例，否则返回null
     */
    public abstract List<OrderDetails> selectByOrderId(Integer orderId);
}