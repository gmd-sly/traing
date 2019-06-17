package com.springcloud.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springcloud.entity.TypeOne;
import com.springcloud.entity.TypeTwo;
import com.springcloud.service.TypeService;
import com.springcloud.vo.ResultValue;

@RestController
@RequestMapping("type")
public class TypeController {
	
	@Autowired
	private TypeService typeService;
	
	@RequestMapping(value = "/selectAll")
	public ResultValue selectAll() {
		ResultValue rv = new ResultValue();
		
		try {
			//调用service相应的方法查询所有一级类别的信息，并保存查询的结果
			 List<TypeOne> list = this.typeService.selectAllTypeOne();
			//如果查询成功
			if(list !=null && list.size() > 0) {
			  //设置结果的状态标记为0
				rv.setCode(0);
			  //创建Map集合
				Map<String,Object> map =new HashMap<>();
			  //将查询结果存放入Map集合中
			    map.put("typeOneList", list);
			  //将Map集合存入ResultValue对象中
			    rv.setDataMap(map);
			  //返回ResultValue对象
			    return rv;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		rv.setCode(1);
		return rv;
	}
	
	@RequestMapping(value = "selectById")
	public ResultValue selectById(@RequestParam("typeOneId") Integer typeOneId) {
		ResultValue rv = new ResultValue();
		
		try {
			//调用service相应的方法查询所有一级类别的信息，并保存查询的结果
			List<TypeTwo> list = this.typeService.selectTypeTwoByTypeOneId(typeOneId);
			//如果查询成功
			if(list != null && list.size() > 0) {
			//设置结果的状态标记为0
				rv.setCode(0);
			//创建Map集合
				Map<String, Object> map = new HashMap<>();
			//将查询结果存放入Map集合中
				map.put("typeTwoList", list);
			//将Map集合存入ResultValue对象中
				rv.setDataMap(map);
			//返回ResultValue对象
				return rv;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		rv.setCode(1);
		return rv;
		
	}

}
