/*
 * Copyright (C), 2002-2019, 苏宁易购电子商务有限公司
 * Author:   14060860-李世辉
 * FileName: BarService
 * Date:     2019/12/9  19:12
 * Description: //模块目的、功能描述
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.dubbo.demo.provider.api;

import com.dubbo.demo.provider.dmo.User;

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
