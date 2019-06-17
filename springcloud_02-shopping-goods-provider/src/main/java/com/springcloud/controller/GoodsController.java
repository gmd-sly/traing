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
import com.springcloud.entity.Goods;
import com.springcloud.service.GoodsService;
import com.springcloud.vo.ResultValue;

/**
 * ��Ʒ���Ʋ�
 * 
 * @author sly
 *
 */
@RestController
@RequestMapping("goods")
public class GoodsController {
	
	@Autowired
	private GoodsService goodsService;
	
	@RequestMapping(value = "/insert")
	public ResultValue insert(Goods goods) {
		ResultValue rv = new ResultValue();
		
		try {
			Integer insert = this.goodsService.insert(goods);
			if(insert > 0) {
				rv.setCode(0);
				rv.setMessage("��Ʒ��Ϣ¼��ɹ�������");
				return rv;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		rv.setCode(1);
		rv.setMessage("��Ʒ��Ϣ¼��ʧ�ܣ�����");
		return rv;		
	}
	
	/**
	 * ��ѯָ����ŵ���Ʒ��Ϣ
	 * 
	 * @param goods  ��ѯ��Ʒ��Ϣ
	 * @param pageNumber  ��Ʒ���
	 * @return
	 */
	@RequestMapping(value = "/select")
	public ResultValue select(Goods goods,@RequestParam("pageNumber") Integer pageNumber) {
		ResultValue rv = new ResultValue();
		try {
			//��ѯ������������Ʒ��Ϣ
			PageInfo<Goods> pageInfo = this.goodsService.select(goods, pageNumber);
			//�ӷ�ҳ��Ϣ�л����Ʒ��Ϣ
			List<Goods> list = pageInfo.getList();
			//�����ѯ����������������Ʒ��Ϣ
			if(list !=null && list.size() >0) {
				rv.setCode(0); 
				Map<String, Object> map = new HashMap<>();
				//����Ʒ��Ϣ��ָ���ļ�����Map������
				map.put("goodsList", list);
				
				PageUtils pageUtils = new PageUtils(12,pageInfo.getPages() * 12);
				pageUtils.setPageNumber(pageNumber);
				//����Ʒ��Ϣ��ָ���ļ�����Map������
				map.put("pageUtils", pageUtils);
				
				rv.setDataMap(map);
				return rv;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		rv.setCode(1);
		rv.setMessage("û���ҵ�������������Ʒ��Ϣ��������");
		return rv;
		
	}
	
	@RequestMapping(value = "/updateById")
	public ResultValue updateById(Goods goods) {
     ResultValue rv = new ResultValue();
		
		try {
			 Integer update = this.goodsService.updateGoodsById(goods);
			if(update > 0) {
				rv.setCode(0);
				rv.setMessage("��Ʒ��Ϣ�޸ĳɹ�������");
				return rv;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		rv.setCode(1);
		rv.setMessage("��Ʒ��Ϣ�޸�ʧ�ܣ�����");
		return rv;		
	}
	
	/**
	 * �޸�ָ����ŵ���Ʒ��Ϣ
	 * 
	 * @param goods  �޸ĵ���Ʒ��Ϣ
	 * @return
	 */
	@RequestMapping(value = "/update")
	public ResultValue update(Goods goods) {
     ResultValue rv = new ResultValue();
		
		try {
			 Integer update = this.goodsService.update(goods);
			if(update > 0) {
				rv.setCode(0);
				rv.setMessage("商品信息修改成功！！");
				return rv;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		rv.setCode(1);
		rv.setMessage("商品信息修改失败！！！");
		return rv;		
	}
	
	/**
	 * 查询销量前10的商品信息
	 * 
	 * @return 
	 */
	@RequestMapping(value = "/selectGroup")
	public ResultValue selectGroup() {
		ResultValue rv = new ResultValue();
		
		try {
			List<Goods> list = this.goodsService.selectGroup();
			if(list !=null && list.size() > 0) {
				rv.setCode(0);
				//创建两个集合，用于保存柱状图x抽与y轴的数据
				List<String> x = new ArrayList<>();
				List<Integer> y = new ArrayList<>();
				//将查询结果中商品名称存入x集合，销量存入y集合
				for(Goods goods : list) {
					x.add(goods.getGoodsName());
					y.add(goods.getGoodsSum());
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

