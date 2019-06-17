package com.springcloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * order_details���Ӧ��ʵ���࣬���ڷ�װһ�ж�����ϸ��Ϣ
 * @author sly
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetails implements java.io.Serializable {
   
	private static final long serialVersionUID = -3288418379990100414L;

	/*
	 * 订单明细编号
	 */
	private Integer orderDetailId;

	/*
	 * 订单编号
	 */
    private Integer orderId;

    /*
     * 商品编号
     */
    private Integer goodsId;

    /*
     * 商品名称
     */
    private String goodsName;

    /*
     * 成交价
     */
    private Double goodsFinalPrice;

    /*
      * 成交数量
     */
    private Integer goodsFinalNum;

   
}