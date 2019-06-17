package com.springcloud.dao;

import com.springcloud.entity.Goods;
import java.util.List;

public interface GoodsMapper {
    int deleteByPrimaryKey(Integer goodsId);

    int insert(Goods record);

    Goods selectByPrimaryKey(Integer goodsId);

    List<Goods> selectAll();

    int updateByPrimaryKey(Goods record);
    /**
             * 查询goods表中满足条件的商品信息
     * 
     * @param goods  查询条件
     * @return  成功返回java.util.list类型的实例，否则返回null
     */
    public abstract List<Goods> select(Goods goods);
    
    /**
              * ���������޸�DOODS����ָ��GOODS_ID����Ʒ��Ϣ
     * 
     * @param goods  �޸���Ʒ��Ϣ
     * @return  �ɹ����ش���0�����������򷵻�С�ڵ���0������
     */
    public abstract Integer updateGoodsById(Goods goods);
    
    /**
               * 查询销量前10的商品信息
     * 
     * @return 成功返回java.util.list类型的实例，否则返回null
     */
    public abstract List<Goods> selectGroup(); 
  
    
}