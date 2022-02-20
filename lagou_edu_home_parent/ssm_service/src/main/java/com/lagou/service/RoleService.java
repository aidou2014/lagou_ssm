package com.lagou.service;

import com.lagou.domain.*;

import java.util.List;

/**
 * @author liangchuancan
 * @description
 * @date 2022年02月17日 23:16
 */
public interface RoleService {

    // 查询所有角色（条件）
    public List<Role> findAllRole(Role role);

    // 新增角色
    public void saveRole(Role role);

    // 更新角色
    public void updateRole(Role role);

    // 删除角色
    public void deleteRole(Integer rid);

    // 根据角色ID查询该角色关联的菜单信息ID [1,2,3,5]
    public List<Integer> findMenuByRoleId(Integer roleId);

    // 为角色分配菜单信息
    public void roleContextMenu(RoleMenuVo roleMenuVo);

    // 根据角色ID查询该角色关联的资源信息
    public List<ResourceCategory> findResourceByRoleId(Integer roleId);

    // 为角色分配资源
    public void roleContextResource(RoleResourceVo roleResourceVo);




}
