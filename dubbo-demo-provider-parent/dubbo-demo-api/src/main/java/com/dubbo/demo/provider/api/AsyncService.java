
package com.dubbo.demo.provider.api;

import java.util.concurrent.CompletableFuture;

/**
 * 〈一句话功能简述〉
 * 〈异步执行service接口〉
 *
 * @USER 14060860-李世辉
 * @DATE 2019/12/10 10:30
 * @SEE [相关类/方法]（可选）
 * @SINCE [产品/模块版本] （可选）
 */
public interface AsyncService {

    CompletableFuture<String> sayHello(String name);

}
