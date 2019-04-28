package com.yukong.panda.message.handler;

import com.yukong.panda.common.template.MessageTemplate;

/**
 * @author: yukong
 * @date: 2018/11/30 17:41
 */
public abstract class AbstractMessageHandler implements MessageHandler {

    /**
     * 参数校验
     * @param messageTemplate
     */
    @Override
    public abstract void check(MessageTemplate messageTemplate);

    /**
     * 执行发送短信
     * @param messageTemplate
     * @return
     */
    @Override
    public abstract Boolean execute(MessageTemplate messageTemplate) ;

    /**
     * 发送失败回调处理
     * @param messageTemplate
     */
    @Override
    public abstract void fail(MessageTemplate messageTemplate);

    /**
     * 发送短信主入口
     * @param messageTemplate
     */
    @Override
    public void handleMessage(MessageTemplate messageTemplate) {
        check(messageTemplate);
        if(!execute(messageTemplate)){
            fail(messageTemplate);
        }
    }
}
