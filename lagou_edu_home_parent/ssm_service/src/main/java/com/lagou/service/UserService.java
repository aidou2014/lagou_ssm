package com.lagou.service;

import com.github.pagehelper.PageInfo;
import com.lagou.domain.ResponseResult;
import com.lagou.domain.Role;
import com.lagou.domain.User;
import com.lagou.domain.UserVo;

import java.util.List;

/**
 * @author liangchuancan
 * @description
 * @date 2022年02月16日 23:12
 */
public interface UserService {

    // 多条件分页查询
    public PageInfo<User> findAllUserByPage(UserVo userVo);

    // 更新用户状态
    public void updateUserStatus(Integer id, String status);

    // 用户登录
    public User login(User user) throws Exception;

    // 根据用户id查询关联的角色信息(回显)
    public List<Role> findUserRoleById(Integer uid);

    // 为用户分配角色
    public void userContextRole(UserVo userVo);

    // 获取用户权限，进行菜单动态展示
    ResponseResult getUserPermissions(Integer uid);
}
