package com.gofocus.springcloud.serviceorder.dao;

import generate.OrderEvent;
import generate.OrderEventDao;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: GoFocus
 * @Date: 2020-09-12 14:24
 * @Description:
 */

@Mapper
public interface OrderEventCustomDao extends OrderEventDao {

    List<OrderEvent> selectByOrderType(String orderType);

    int updateOrderTypeByPrimaryKey(@Param("ids") List<Integer> ids, @Param("orderType") String orderType);

}
