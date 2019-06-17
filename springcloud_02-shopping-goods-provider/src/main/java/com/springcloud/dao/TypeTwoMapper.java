package com.springcloud.dao;

import com.springcloud.entity.TypeTwo;
import java.util.List;

public interface TypeTwoMapper {
    int deleteByPrimaryKey(Integer typeTwoId);

    int insert(TypeTwo record);

    TypeTwo selectByPrimaryKey(Integer typeTwoId);

    List<TypeTwo> selectAll();

    int updateByPrimaryKey(TypeTwo record);
    
    /**
     * 查询TYPE_TWO表中指定TYPE_ONE_ID的二级类别信息
     * @param typeOneId 一级类别编号
     * @return 成功返回java.util.List类型的实例，否则返回null
     */
    public abstract List<TypeTwo> selectByTypeOneId(Integer typeOneId);
}