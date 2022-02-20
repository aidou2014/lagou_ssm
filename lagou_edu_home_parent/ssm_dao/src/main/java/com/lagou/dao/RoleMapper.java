package com.lagou.dao;

import com.lagou.domain.*;

import java.util.List;

/**
 * @author liangchuancan
 * @description
 * @date 2022年02月17日 23:11
 */
public interface RoleMapper {

    // 查询所有角色&条件进行查询
    public List<Role> findAllRole(Role role);

    // 新增角色
    public void saveRole(Role role);

    // 更新角色
    public void updateRole(Role role);

    // 删除角色
    public void deleteRole(Integer rid);

    // 根据roleId清空中间表的关联关系
    public void deleteRoleContextMenu(Integer rid);

    // 根据角色ID查询该角色关联的菜单信息ID [1,2,3,5]
    public List<Integer> findMenuByRoleId(Integer roleId);

    // 为角色分配菜单信息
    public void roleContextMenu(Role_menu_relation role_menu_relation);

    // 根据roleId清空中间表的关联关系
    public void deleteRoleContextResource(Integer rid);

    // 根据角色ID查询该角色关联的资源信息
    public List<ResourceCategory> findResourceByRoleId(Integer roleId);

    // 为角色分配资源
    public void roleContextResource(Role_Resource_Relation role_resource_relation);

}
