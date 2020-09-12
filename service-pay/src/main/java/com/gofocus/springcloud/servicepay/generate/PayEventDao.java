package com.gofocus.springcloud.servicepay.generate;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PayEventDao {
    int deleteByPrimaryKey(Integer id);

    int insert(PayEvent record);

    int insertSelective(PayEvent record);

    PayEvent selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PayEvent record);

    int updateByPrimaryKey(PayEvent record);
}