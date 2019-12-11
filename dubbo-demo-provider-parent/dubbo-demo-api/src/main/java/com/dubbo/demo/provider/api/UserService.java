
package com.dubbo.demo.provider.api;

import com.dubbo.demo.provider.dmo.User;

import java.util.List;

/**
 * 〈一句话功能简述〉
 * 〈〉
 *
 * @USER 14060860-李世辉
 * @DATE 2019/11/27 20:08
 * @SEE [相关类/方法]（可选）
 * @SINCE [产品/模块版本] （可选）
 */
public interface UserService {

    List<User> queryAllUser();

    void deleteUser(String userName);
}
