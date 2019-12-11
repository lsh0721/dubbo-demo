
package com.dubbo.demo.provider.api;

import java.util.Map;

/**
 * 〈一句话功能简述〉
 * 〈〉
 *
 * @USER 14060860-李世辉
 * @DATE 2019/12/9 19:12
 * @SEE [相关类/方法]（可选）
 * @SINCE [产品/模块版本] （可选）
 */
public interface BarService {

    String sayHello(String name);

    Map<String, Object> saveUser(Map<String, Object> request);
}
