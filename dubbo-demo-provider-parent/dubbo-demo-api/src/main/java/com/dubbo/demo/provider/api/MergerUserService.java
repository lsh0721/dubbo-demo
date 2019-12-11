
package com.dubbo.demo.provider.api;

import com.dubbo.demo.provider.dmo.User;

import java.util.List;

/**
 * 〈一句话功能简述〉
 * 〈分组聚合 service〉
 *
 * @USER 14060860-李世辉
 * @DATE 2019/12/9 11:12
 * @SEE [相关类/方法]（可选）
 * @SINCE [产品/模块版本] （可选）
 */
public interface MergerUserService {

    /**
     * 分组聚合查询用户
     *
     * @return
     */
    List<User> queryUserForMerger();
}
