package com.springcloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * TYPE_ONE表对应的实体类你，用于保存表中一行一级类别信息
 * @author sunliyan
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TypeTwo {
	/**
	 * 类型二编号
	 */
    private Integer typeTwoId;

    /**
	 * 类型二名称
	 */
    private String typeTwoName;

    /**
	 * 类型一编号
	 */
    private Integer typeOneId;

    /**
	 * 备注
	 */
    private String typeTwoRemark;

   
}