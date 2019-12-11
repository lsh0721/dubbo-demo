
package com.dubbo.demo.provider.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 〈一句话功能简述〉
 * 〈〉
 *
 * @USER 14060860-李世辉
 * @DATE 2019/11/27 19:26
 * @SEE [相关类/方法]（可选）
 * @SINCE [产品/模块版本] （可选）
 */
@RestController
@RequestMapping("hello")
public class HelloController {

    @RequestMapping("index.do")
    public String sayHello() {
        return "dubbo-demo-web say hello";
    }
}
