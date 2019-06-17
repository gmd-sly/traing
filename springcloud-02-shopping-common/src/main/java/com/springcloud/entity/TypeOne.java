package com.springcloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * TYPE_TWO表对应的实体类你，用于保存表中一行二级类别信息
 * @author sly
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TypeOne {
	/**
	 * 类型一编号
	 */
    private Integer typeOneId;
   
    /**
     * 类型一名称
     */
    private String typeOneName;

    /*
     * 序号
     */
    private Integer typeOneNum;

    /**
     * 备注
     */
    private String typeOneRemark;

    
}