package com.gofocus.springcloud.servicepay.dao;

import com.gofocus.springcloud.servicepay.generate.PayEvent;
import com.gofocus.springcloud.servicepay.generate.PayEventDao;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: GoFocus
 * @Date: 2020-09-12 17:55
 * @Description:
 */

@Mapper
public interface PayEventCustomDao extends PayEventDao {

    int insertWithId(PayEvent payEvent);

}
