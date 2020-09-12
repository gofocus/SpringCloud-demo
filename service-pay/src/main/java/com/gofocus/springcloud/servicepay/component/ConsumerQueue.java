package com.gofocus.springcloud.servicepay.component;

import com.gofocus.springcloud.servicepay.dao.PayEventCustomDao;
import com.gofocus.springcloud.servicepay.generate.PayEvent;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Session;
import javax.jms.TextMessage;

/**
 * @Author: GoFocus
 * @Date: 2020-09-12 16:54
 * @Description:
 */

@Component
public class ConsumerQueue {

    @Autowired
    private PayEventCustomDao payEventCustomDao;

    @JmsListener(destination = "ActiveMQQueue", containerFactory = "jmsListenerContainerFactory")
    public void receive(TextMessage textMessage, Session session) throws JMSException {
        try {
            System.out.println("收到的消息:" + textMessage.getText());
            String content = textMessage.getText();

            PayEvent payEvent = (PayEvent) JSONObject.toBean(JSONObject.fromObject(content), PayEvent.class);
            payEventCustomDao.insertWithId(payEvent);
            // 业务完成，确认消息 消费成功
            textMessage.acknowledge();
        } catch (JMSException e) {
            e.printStackTrace();
            System.out.println("异常了");
            session.recover();
        }
    }

    /**
     * 补偿 处理（人工，脚本）。自己根据自己情况。
     *
     * @param text
     */
    @JmsListener(destination = "DLQ.ActiveMQQueue")
    public void receive2(String text) {
        System.out.println("死信队列:" + text);
    }


}
