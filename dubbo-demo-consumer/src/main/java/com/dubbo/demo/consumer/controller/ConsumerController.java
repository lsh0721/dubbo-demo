
package com.dubbo.demo.consumer.controller;

import com.dubbo.demo.provider.api.AsyncService;
import com.dubbo.demo.provider.api.HelloService;
import com.dubbo.demo.provider.api.MergerUserService;
import com.dubbo.demo.provider.api.UserService;
import com.dubbo.demo.provider.dmo.User;
import jdk.nashorn.internal.ir.ReturnNode;
import org.apache.dubbo.config.ReferenceConfig;
import org.apache.dubbo.rpc.service.EchoService;
import org.apache.dubbo.rpc.service.GenericService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

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

    private static final Logger LOGGER = LoggerFactory.getLogger(ConsumerController.class);

    @Autowired(required = false)
    private HelloService helloService;

    @Autowired(required = false)
    private UserService userService;

    @Autowired(required = false)
    private MergerUserService mergerUserService;

    @Autowired(required = false)
    private AsyncService asyncService;

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

    /**
     * 分组聚合
     *
     * @return
     */
    @RequestMapping("queryUserForMerger.do")
    public List<User> queryUserForMerger() {
        List<User> userList = mergerUserService.queryUserForMerger();
        return userList;
    }

    /**
     * 泛化调用
     *
     * @return
     */
    @RequestMapping("saveUserForGeneric.do")
    public Map<String, Object> saveUserForGeneric() {
        /**XML配置的接口泛化调用
        GenericService barService = (GenericService) applicationContext.getBean("barService");
        Map<String, Object> request = new HashMap<>();
        request.put("userName", "11111");
        request.put("address", "22222");
        Object response = barService.$invoke("saveUser", new String[]{"java.util.Map"}, new Object[]{request});
        return (Map<String, Object>) response;**/

        /**api方式的接口泛化调用**/
         ReferenceConfig<GenericService> reference = new ReferenceConfig<GenericService>();
         reference.setInterface("com.dubbo.demo.provider.api.BarService");
         reference.setGeneric(true);
         GenericService genericService = reference.get();
         Map<String, Object> request = new HashMap<>();
         request.put("userName", "11111");
         request.put("address", "22222");
         Map<String, Object> response = (Map<String, Object>) genericService.$invoke("saveUser",
         new String[]{"java.util.Map"}, new Object[]{request});
         return response;
    }

    /**
     * 回声测试
     *
     * @return
     */
    @RequestMapping("echo.do")
    public String echo() {
        EchoService echoService = (EchoService) helloService;
        String status = (String) echoService.$echo("hello");
        assert (status.equals("hello"));
        return status;
    }

    /**
     * 异步调用
     *
     * @return
     */
    @RequestMapping("async.do")
    public String async() throws Exception {
        //调用
        LOGGER.info("异步调用开始...");
        CompletableFuture<String> future = asyncService.sayHello("async call request");
        //回调
        future.whenComplete((v, t) -> {
            if (t != null) {
                t.printStackTrace();
            } else {
                LOGGER.info("异步执行结果:{}", v);
            }
        });
        LOGGER.info("可以处理器其他逻辑");
        // 早于结果输出
        LOGGER.info("先与返回结果执行.");
        return future.get();
    }

}
