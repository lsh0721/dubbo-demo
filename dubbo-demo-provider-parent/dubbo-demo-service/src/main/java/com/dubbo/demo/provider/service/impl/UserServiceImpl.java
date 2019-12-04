/*
 * Copyright (C), 2002-2019, 苏宁易购电子商务有限公司
 * Author:   14060860-李世辉
 * FileName: UserServiceImpl
 * Date:     2019/11/27  20:09
 * Description: //模块目的、功能描述
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.dubbo.demo.provider.service.impl;

import com.dubbo.demo.provider.api.UserService;
import com.dubbo.demo.provider.dmo.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * 〈一句话功能简述〉
 * 〈〉
 *
 * @USER 14060860-李世辉
 * @DATE 2019/11/27 20:09
 * @SEE [相关类/方法]（可选）
 * @SINCE [产品/模块版本] （可选）
 */
public class UserServiceImpl implements UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public List<User> queryAllUser() {
        LOGGER.info("UserServiceImpl.queryAllUser start");
/*        try {
            //休眠1s 测试 LeastActive LoadBalance策略
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        List<User> userList = new ArrayList<>();
        User user1 = new User();
        user1.setUserName("张三");
        user1.setAddress("南京");
        User user2 = new User();
        user2.setUserName("李四");
        user2.setAddress("北京");
        userList.add(user1);
        userList.add(user2);
        LOGGER.info("UserServiceImpl.queryAllUser end");
        return userList;
    }

    @Override
    public void deleteUser(String userName) {
        LOGGER.info("UserServiceImpl.deleteUser start");
        LOGGER.info("doing delete user......");
        LOGGER.info("UserServiceImpl.deleteUser end");
    }
}
