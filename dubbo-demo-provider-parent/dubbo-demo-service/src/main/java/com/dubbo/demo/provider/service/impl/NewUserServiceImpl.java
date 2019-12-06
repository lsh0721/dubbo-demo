/*
 * Copyright (C), 2002-2019, 苏宁易购电子商务有限公司
 * Author:   14060860-李世辉
 * FileName: NewUserServiceImpl
 * Date:     2019/12/6  19:25
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
 * @DATE 2019/12/6 19:25
 * @SEE [相关类/方法]（可选）
 * @SINCE [产品/模块版本] （可选）
 */
public class NewUserServiceImpl implements UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(NewUserServiceImpl.class);

    @Override
    public List<User> queryAllUser() {
        LOGGER.info("NewUserServiceImpl.queryAllUser");
        List<User> userList = new ArrayList<>();
        User user = new User();
        user.setUserName("王五");
        user.setAddress("上海");
        userList.add(user);
        return userList;
    }

    @Override
    public void deleteUser(String userName) {

    }
}
