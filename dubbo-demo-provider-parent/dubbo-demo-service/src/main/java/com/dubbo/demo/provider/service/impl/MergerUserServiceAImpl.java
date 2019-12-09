/*
 * Copyright (C), 2002-2019, 苏宁易购电子商务有限公司
 * Author:   14060860-李世辉
 * FileName: MergerUserServiceAImpl
 * Date:     2019/12/9  11:10
 * Description: //模块目的、功能描述
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.dubbo.demo.provider.service.impl;

import com.dubbo.demo.provider.api.MergerUserService;
import com.dubbo.demo.provider.api.UserService;
import com.dubbo.demo.provider.dmo.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * 〈一句话功能简述〉
 * 〈分组聚合实现类A〉
 *
 * @USER 14060860-李世辉
 * @DATE 2019/12/9 11:10
 * @SEE [相关类/方法]（可选）
 * @SINCE [产品/模块版本] （可选）
 */
public class MergerUserServiceAImpl implements MergerUserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(MergerUserServiceAImpl.class);

    @Override
    public List<User> queryUserForMerger() {
        LOGGER.info("MergerUserServiceAImpl.queryUserForMerger");
        List<User> userList = new ArrayList<>();
        User userA1 = new User();
        userA1.setAddress("南京-鼓楼");
        userA1.setUserName("A1");

        User userA2 = new User();
        userA2.setAddress("南京-建邺");
        userA2.setUserName("A2");

        User userA3 = new User();
        userA3.setAddress("南京-江宁");
        userA3.setUserName("A3");

        userList.add(userA1);
        userList.add(userA2);
        userList.add(userA3);
        return userList;
    }
}
