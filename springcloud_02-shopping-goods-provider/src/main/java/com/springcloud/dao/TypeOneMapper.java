package com.springcloud.dao;

import com.springcloud.entity.TypeOne;
import java.util.List;

public interface TypeOneMapper {
    int deleteByPrimaryKey(Integer typeOneId);

    int insert(TypeOne record);

    TypeOne selectByPrimaryKey(Integer typeOneId);

    List<TypeOne> selectAll();

    int updateByPrimaryKey(TypeOne record);
}