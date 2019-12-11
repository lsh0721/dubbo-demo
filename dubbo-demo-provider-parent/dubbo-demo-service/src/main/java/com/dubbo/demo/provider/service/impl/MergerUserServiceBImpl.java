
package com.dubbo.demo.provider.service.impl;

import com.dubbo.demo.provider.api.MergerUserService;
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
 * @DATE 2019/12/9 11:17
 * @SEE [相关类/方法]（可选）
 * @SINCE [产品/模块版本] （可选）
 */
public class MergerUserServiceBImpl implements MergerUserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(MergerUserServiceBImpl.class);

    @Override
    public List<User> queryUserForMerger() {
        LOGGER.info("MergerUserServiceBImpl.queryUserForMerger");

        List<User> userList = new ArrayList<>();
        User userB1 = new User();
        userB1.setAddress("南京-江北新区");
        userB1.setUserName("B1");

        User userB2 = new User();
        userB2.setAddress("南京-雨花");
        userB2.setUserName("B2");

        User userB3 = new User();
        userB3.setAddress("南京-栖霞");
        userB3.setUserName("B1");

        userList.add(userB1);
        userList.add(userB2);
        userList.add(userB3);

        return userList;
    }
}
