
package com.dubbo.demo.provider.service.impl;

import com.dubbo.demo.provider.api.BarService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * 〈一句话功能简述〉
 * 〈〉
 *
 * @USER 14060860-李世辉
 * @DATE 2019/12/9 19:42
 * @SEE [相关类/方法]（可选）
 * @SINCE [产品/模块版本] （可选）
 */
public class BarServiceImpl implements BarService {

    private static final Logger LOGGER = LoggerFactory.getLogger(BarServiceImpl.class);

    @Override
    public String sayHello(String name) {
        return "hello :" + name;
    }

    @Override
    public Map<String, Object> saveUser(Map<String,Object> request) {
        LOGGER.info("BarServiceImpl.saveUser start:{}",request);
        LOGGER.info("BarServiceImpl.saveUser end");
        Map<String, Object> response = new HashMap<>();
        response.put("responseCode", "0000");
        response.put("responseMsg", "保存成功");
        return response;
    }
}
