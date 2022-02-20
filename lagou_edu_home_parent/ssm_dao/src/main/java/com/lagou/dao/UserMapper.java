package com.lagou.dao;

import com.lagou.domain.*;

import java.util.List;

/**
 * @author liangchuancan
 * @description
 * @date 2022年02月16日 23:00
 */
public interface UserMapper {

    // 用户分页&多条件组合查询
    public List<User> findAllUserByPage(UserVo userVo);

    // 用户状态更新
    public void updateUserStatus(User user);

    // 用户登录（根据用户名查询具体的用户信息）
    public User login(User user);


    // 根据用户id查询关联的角色信息(回显分配菜单节码)
    public List<Role> findUserRoleById(Integer uid);

    // 根据用户id清空中间表
    public void deleteUserContextRole(Integer userId);

    // 分配角色
    public void userContextRole(User_Role_relation user_role_relation);

    // 根据角色id查询父级菜单信息
    public List<Menu> findParentMenuByRoleId(List<Integer> ids);

    // 根据父级菜单查询子级菜单
    public List<Menu> findSubMenuByPid(Integer pid);

    // 获取用户用户的资源权限信息
    public List<Resource> findResourceByRoleId(List<Integer> ids);

}
