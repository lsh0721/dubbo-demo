/*
 * Copyright (C), 2002-2019, 苏宁易购电子商务有限公司
 * Author:   14060860-李世辉
 * FileName: ConsumerController
 * Date:     2019/11/27  19:39
 * Description: //模块目的、功能描述
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.dubbo.demo.consumer.controller;

import com.dubbo.demo.provider.api.HelloService;
import com.dubbo.demo.provider.api.MergerUserService;
import com.dubbo.demo.provider.api.UserService;
import com.dubbo.demo.provider.dmo.User;
import org.apache.dubbo.rpc.service.EchoService;
import org.apache.dubbo.rpc.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 〈一句话功能简述〉
 * 〈〉
 *
 * @USER 14060860-李世辉
 * @DATE 2019/11/27 19:39
 * @SEE [相关类/方法]（可选）
 * @SINCE [产品/模块版本] （可选）
 */
@RestController
@RequestMapping("hello")
public class ConsumerController {

    @Autowired(required = false)
    private HelloService helloService;

    @Autowired(required = false)
    private UserService userService;

    @Autowired(required = false)
    private MergerUserService mergerUserService;

    @Autowired
    private ApplicationContext applicationContext;

    @RequestMapping("index.do")
    public String index() {
        return "dubbo-demo-consumer say hello";
    }

    @RequestMapping("sayHello.do")
    public String sayHello(String userName) {
        return helloService.sayHello(userName);
    }

    @RequestMapping("queryAllUser.do")
    public List<User> queryAllUser() {
        List<User> userList = userService.queryAllUser();
        return userList;
    }

    @RequestMapping("queryUserForMerger.do")
    public List<User> queryUserForMerger() {
        List<User> userList = mergerUserService.queryUserForMerger();
        return userList;
    }

    @RequestMapping("saveUserForGeneric.do")
    public Map<String, Object> saveUserForGeneric() {
        /**XML配置的接口泛化调用**/
        GenericService barService = (GenericService) applicationContext.getBean("barService");
        Map<String, Object> request = new HashMap<>();
        request.put("userName", "11111");
        request.put("address", "22222");
        Object response = barService.$invoke("saveUser", new String[]{"java.util.Map"}, new Object[]{request});
        return (Map<String, Object>) response;

        /**api方式的接口泛化调用
         ReferenceConfig<GenericService> reference = new ReferenceConfig<GenericService>();
         reference.setInterface("com.dubbo.demo.provider.api.BarService");
         reference.setGeneric(true);
         GenericService genericService = reference.get();
         Map<String, Object> request = new HashMap<>();
         request.put("userName", "11111");
         request.put("address", "22222");
         Map<String, Object> response = (Map<String, Object>) genericService.$invoke("saveUser",
         new String[]{"java.util.Map"}, new Object[]{request});
         return response;**/
    }

    @RequestMapping("echo.do")
    public String echo() {
        EchoService echoService = (EchoService) helloService;
        String status = (String) echoService.$echo("hello");
        assert(status.equals("hello"));
        return status;
    }

}
