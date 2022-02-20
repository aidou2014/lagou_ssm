package com.lagou.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lagou.dao.UserMapper;
import com.lagou.domain.*;
import com.lagou.service.UserService;
import com.lagou.utils.Md5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author liangchuancan
 * @description
 * @date 2022年02月16日 23:13
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public PageInfo<User> findAllUserByPage(UserVo userVo) {
        PageHelper.startPage(userVo.getCurrentPage(), userVo.getPageSize());
        List<User> users = userMapper.findAllUserByPage(userVo);
        return new PageInfo<>(users);
    }

    @Override
    public void updateUserStatus(Integer id, String status) {
        User user = new User();
        user.setId(id);
        user.setStatus(status);
        user.setUpdate_time(new Date());

        userMapper.updateUserStatus(user);
    }

    @Override
    public User login(User user) throws Exception {
        // 1.调用mapper方法，user1中包含密文密码
        User user1 = userMapper.login(user);

        // 校验密码正确性
        if (user1 != null && Md5.verify(user.getPhone(), "lagou", user1.getPassword())) {
            return user1;
        }
        return null;
    }

    @Override
    public List<Role> findUserRoleById(Integer uid) {
        return userMapper.findUserRoleById(uid);
    }

    @Override
    public void userContextRole(UserVo userVo) {
        // 1. 根据用户id清空中间表关系
        userMapper.deleteUserContextRole(userVo.getUserId());

        // 2. 为用户分配角色
        for (Integer roleId : userVo.getRoleIdList()) {
            // 封装数据
            User_Role_relation userRoleRelation = new User_Role_relation();
            userRoleRelation.setUserId(userVo.getUserId());
            userRoleRelation.setRoleId(roleId);
            Date date = new Date();
            userRoleRelation.setCreatedTime(date);
            userRoleRelation.setUpdatedTime(date);
            userRoleRelation.setCreatedBy("system");
            userRoleRelation.setUpdatedby("system");

            // 调用mapper方法
            userMapper.userContextRole(userRoleRelation);
        }
    }

    @Override
    public ResponseResult getUserPermissions(Integer uid) {
        // 1. 获取当前用户拥有的角色
        List<Role> roles = userMapper.findUserRoleById(uid);
        // 2. 获取角色id，保存到list集合中
        List<Integer> roleIds = new ArrayList<>();
        for (Role role : roles) {
            roleIds.add(role.getId());
        }
        // 3. 根据角色id查询父级菜单
        List<Menu> parentMenu = userMapper.findParentMenuByRoleId(roleIds);

        // 4. 根据父菜单关联的子菜单
        for (Menu menu : parentMenu) {
            List<Menu> subMenu = userMapper.findSubMenuByPid(menu.getId());
            menu.setSubMenuList(subMenu);
        }
        // 5. 获取资源信息
        List<Resource> resourceList = userMapper.findResourceByRoleId(roleIds);

        // 6. 封装并返回
        Map<String, Object> map = new HashMap<>();
        map.put("menuList", parentMenu);
        map.put("resourceList", resourceList);

        return new ResponseResult(true, 200, "获取权限信息成功", map);
    }
}
