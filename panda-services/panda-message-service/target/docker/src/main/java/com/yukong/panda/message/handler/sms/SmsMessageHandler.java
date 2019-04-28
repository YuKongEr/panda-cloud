package com.yukong.panda.message.handler.sms;

import com.yukong.panda.common.exception.PandaException;
import com.yukong.panda.common.template.MessageTemplate;
import com.yukong.panda.common.template.sms.SmsMessageTemplate;
import com.yukong.panda.message.handler.AbstractMessageHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;

/**
 * @author: yukong
 * @date: 2018/12/3 09:03
 */
@Slf4j
public abstract class SmsMessageHandler extends AbstractMessageHandler {

    @Override
    public void check(MessageTemplate messageTemplate) {
        if (!(messageTemplate instanceof SmsMessageTemplate)) {
            throw new PandaException("messageTemplate must instance of SmsMessageTemplate");
        }
        SmsMessageTemplate smsMessageTemplate = (SmsMessageTemplate) messageTemplate;
        if(StringUtils.isEmpty(smsMessageTemplate.getMobile())) {
            throw new PandaException("mobile must  not be null");
        }
        if(StringUtils.isEmpty(smsMessageTemplate.getSignName())) {
            throw new PandaException("singName must  not be null");
        }
        if(StringUtils.isEmpty(smsMessageTemplate.getChannel())) {
            throw new PandaException("channel must  not be null");
        }
        if(StringUtils.isEmpty(smsMessageTemplate.getTemplate())) {
            throw new PandaException("template must  not be null");
        }
    }

    @Override
    public abstract Boolean execute(MessageTemplate messageTemplate);

    @Override
    public void fail(MessageTemplate messageTemplate) {
        SmsMessageTemplate smsMessageTemplate = (SmsMessageTemplate) messageTemplate;
        log.error("短信发送失败，手机号:{},签名:{},模板:{}",smsMessageTemplate.getMobile(), smsMessageTemplate.getSignName(), smsMessageTemplate.getTemplate());
    }
}
