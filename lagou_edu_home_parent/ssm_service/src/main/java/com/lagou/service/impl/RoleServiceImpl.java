package com.lagou.service.impl;

import com.lagou.dao.RoleMapper;
import com.lagou.domain.*;
import com.lagou.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author liangchuancan
 * @description
 * @date 2022年02月17日 23:18
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public List<Role> findAllRole(Role role) {
        return roleMapper.findAllRole(role);
    }

    @Override
    public void saveRole(Role role) {
        role.setCreatedBy("system");
        role.setUpdatedBy("system");
        role.setCreatedTime(new Date());
        role.setUpdatedTime(new Date());
        roleMapper.saveRole(role);
    }

    @Override
    public void updateRole(Role role) {
        role.setUpdatedBy("system1");
        role.setUpdatedTime(new Date());
        roleMapper.updateRole(role);
    }

    @Override
    public void deleteRole(Integer rid) {
        roleMapper.deleteRoleContextMenu(rid);
        roleMapper.deleteRoleContextResource(rid);
        roleMapper.deleteRole(rid);
    }

    @Override
    public List<Integer> findMenuByRoleId(Integer roleId) {
        return roleMapper.findMenuByRoleId(roleId);
    }

    @Override
    public void roleContextMenu(RoleMenuVo roleMenuVo) {
        // 1. 清空中间表的关联关系
        roleMapper.deleteRoleContextMenu(roleMenuVo.getRoleId());

        // 2. 为角色分配菜单
        for (Integer mid : roleMenuVo.getMenuIdList()) {
            Role_menu_relation relation = new Role_menu_relation();
            relation.setMenuId(mid);
            relation.setRoleId(roleMenuVo.getRoleId());
            // 手动封装
            relation.setCreatedTime(new Date());
            relation.setUpdatedTime(new Date());
            relation.setCreatedBy("system");
            relation.setUpdatedby("system");

            roleMapper.roleContextMenu(relation);
        }
    }

    @Override
    public List<ResourceCategory> findResourceByRoleId(Integer roleId) {
        return roleMapper.findResourceByRoleId(roleId);
    }

    @Override
    public void roleContextResource(RoleResourceVo roleResourceVo) {
        // 1. 清空中间表的关联关系
        roleMapper.deleteRoleContextMenu(roleResourceVo.getRoleId());

        // 2. 为角色分配菜单
        for (Integer resourceId : roleResourceVo.getResourceIdList()) {
            Role_Resource_Relation roleResourceRelation = new Role_Resource_Relation();
            roleResourceRelation.setResourceId(resourceId);
            roleResourceRelation.setRoleId(roleResourceVo.getRoleId());
            // 手动封装
            roleResourceRelation.setCreatedTime(new Date());
            roleResourceRelation.setUpdatedTime(new Date());
            roleResourceRelation.setCreatedBy("system");
            roleResourceRelation.setUpdatedby("system");

            roleMapper.roleContextResource(roleResourceRelation);
        }
    }
}
