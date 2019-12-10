/*
 * Copyright (C), 2002-2019, 苏宁易购电子商务有限公司
 * Author:   14060860-李世辉
 * FileName: AsyncServiceImpl
 * Date:     2019/12/10  10:33
 * Description: //模块目的、功能描述
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.dubbo.demo.provider.service.impl;

import com.dubbo.demo.provider.api.AsyncService;
import org.apache.dubbo.rpc.RpcContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CompletableFuture;

/**
 * 〈一句话功能简述〉
 * 〈异步执行接口实现〉
 *
 * @USER 14060860-李世辉
 * @DATE 2019/12/10 10:33
 * @SEE [相关类/方法]（可选）
 * @SINCE [产品/模块版本] （可选）
 */
public class AsyncServiceImpl implements AsyncService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AsyncServiceImpl.class);

    @Override
    public CompletableFuture<String> sayHello(String name) {
        LOGGER.info("AsyncServiceImpl.sayHello");
        RpcContext rpcContext = RpcContext.getContext();
        // 建议为supplyAsync提供自定义线程池，避免使用JDK公用线程池
        return CompletableFuture.supplyAsync(() -> {
            System.out.println(rpcContext.getAttachment("consumer-key1"));
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "async response from provider." + name;
        });
    }
}
