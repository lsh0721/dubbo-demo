
package com.dubbo.demo.consumer.service.impl;

import com.dubbo.demo.consumer.service.ConsumerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 〈一句话功能简述〉
 * 〈〉
 *
 * @USER 14060860-李世辉
 * @DATE 2019/12/4 22:19
 * @SEE [相关类/方法]（可选）
 * @SINCE [产品/模块版本] （可选）
 */
public class ConsumerServiceImpl implements ConsumerService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ConsumerServiceImpl.class);

    @Override
    public void onlySubscribe() {
        LOGGER.info("ConsumerServiceImpl.onlySubscribe......");
    }
}
