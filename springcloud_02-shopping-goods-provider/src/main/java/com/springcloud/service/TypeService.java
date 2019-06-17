package com.springcloud.service;

import java.util.List;

import com.springcloud.entity.TypeOne;
import com.springcloud.entity.TypeTwo;

/**
 * 用于定义一级类别与二级类别模块的方法
 * @author sly
 *
 */
public interface TypeService {
	/**
	 * 查询所有一级类别的信息
	 * @return  成功返回java.util.List类型的实例，否则返回null
	 */
	public abstract List<TypeOne> selectAllTypeOne();
	
	/**
	 * 根据一级类别编号查询相应的二级类别信息
	 * 
	 * @param typeOneId  一级类别编号
	 * @return   成功返回java.util.List类型的实例，否则返回null
	 */
	public abstract List<TypeTwo> selectTypeTwoByTypeOneId(Integer typeOneId);
	
}
