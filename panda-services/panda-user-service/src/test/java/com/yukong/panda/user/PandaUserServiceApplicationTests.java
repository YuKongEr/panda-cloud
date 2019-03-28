package com.yukong.panda.user;

import com.yukong.panda.common.constants.MqQueueNameConstant;
import com.yukong.panda.common.enums.SmsMessageChannnelEnum;
import com.yukong.panda.common.template.sms.SmsMessageTemplate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PandaUserServiceApplicationTests {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    public void contextLoads() {
        SmsMessageTemplate smsMessageTemplate = new SmsMessageTemplate();
        smsMessageTemplate.setMobile("15079155614");
        smsMessageTemplate.setSignName("程序咖啡厅");
        String[] params =  {"567821"};
        smsMessageTemplate.setParams(params);
        smsMessageTemplate.setTemplate("238684");
        smsMessageTemplate.setChannel(SmsMessageChannnelEnum.TENCENT_CLOUD.getCode());
        rabbitTemplate.convertAndSend(MqQueueNameConstant.MOBILE_CODE_QUEUE,smsMessageTemplate);
    }

}
