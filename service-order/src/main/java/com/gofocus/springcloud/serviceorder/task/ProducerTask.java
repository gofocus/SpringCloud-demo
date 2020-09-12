package com.gofocus.springcloud.serviceorder.task;

import com.gofocus.springcloud.serviceorder.dao.OrderEventCustomDao;
import generate.OrderEvent;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.jms.Queue;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: GoFocus
 * @Date: 2020-09-12 14:51
 * @Description: 定时任务，将事件表的内容发送给消息队列
 */

@Component
public class ProducerTask {

    @Autowired
    private OrderEventCustomDao orderEventCustomDao;

    @Autowired
    private Queue queue;

    @Autowired
    JmsMessagingTemplate jmsMessagingTemplate;

    @Scheduled(cron = "0/5 * * * * ?")
    @Transactional(rollbackFor = Exception.class)
    public void task() {
        System.out.println("定时任务开始执行");

        List<OrderEvent> orderEvents = orderEventCustomDao.selectByOrderType("1");
        if (orderEvents.size() == 0) {
            System.out.println("没有需要处理的事件");
            return;
        }
        List<Integer> ids = orderEvents.stream().map(OrderEvent::getId).collect(Collectors.toList());
        orderEventCustomDao.updateOrderTypeByPrimaryKey(ids, "2");
        System.out.println("更新数据库完毕");

        for (OrderEvent orderEvent : orderEvents) {
            jmsMessagingTemplate.convertAndSend(queue, JSONObject.fromObject(orderEvent).toString());
        }

    }
}
