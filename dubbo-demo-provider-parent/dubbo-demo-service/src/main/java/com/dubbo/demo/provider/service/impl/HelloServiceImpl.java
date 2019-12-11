
package com.dubbo.demo.provider.service.impl;

import com.dubbo.demo.provider.api.HelloService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 〈一句话功能简述〉
 * 〈〉
 *
 * @USER 14060860-李世辉
 * @DATE 2019/11/29 10:15
 * @SEE [相关类/方法]（可选）
 * @SINCE [产品/模块版本] （可选）
 */
public class HelloServiceImpl implements HelloService {

    private static final Logger LOGGER = LoggerFactory.getLogger(HelloServiceImpl.class);

    @Override
    public String sayHello(String userName) {
        LOGGER.info("HelloServiceImpl.sayHello start userName:{}", userName);
        String result = "dubbo-demo-service say hello :" + userName;
        LOGGER.info("HelloServiceImpl.sayHello end");
        return result;
    }
}
