package com.lagou.controller;

import com.lagou.domain.*;
import com.lagou.service.MenuService;
import com.lagou.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author liangchuancan
 * @description
 * @date 2022年02月17日 23:18
 */
@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @Autowired
    private MenuService menuService;

    /**
     * 根据条件查询所有角色
     */
    @RequestMapping("/findAllRole")
    public ResponseResult findAllRole(@RequestBody Role role) {
        List<Role> roles = roleService.findAllRole(role);
        return new ResponseResult(true, 200, "查询所有角色成功", roles);
    }

    /**
     * 新增&更新角色
     */
    @RequestMapping("/saveOrUpdateRole")
    public ResponseResult saveOrUpdateRole(@RequestBody Role role) {
        if (role.getId() != null) {
            roleService.updateRole(role);
            return new ResponseResult(true, 200, "更新角色成功", null);
        } else {
            roleService.saveRole(role);
            return new ResponseResult(true, 200, "新增角色成功", null);
        }
    }

    /**
     * 删除角色
     */
    @RequestMapping("/deleteRole")
    public ResponseResult deleteRole(Integer id) {
        roleService.deleteRole(id);
        return new ResponseResult(true, 200, "删除角色成功", null);
    }

    /**
     * 查询所有的父子菜单信息
     */
    @RequestMapping("/findAllMenu")
    public ResponseResult findAllMenu() {
        // -1表示查询所有的父级菜单，之后依据父级的id查询对应子级的菜单
        List<Menu> menuList = menuService.findSubMenuListByPid(-1);

        // 响应数据
        Map<String, Object> map = new HashMap<>(16);
        map.put("parentMenuList", menuList);

        return new ResponseResult(true, 200, "查询所有的父子级菜单成功", map);
    }

    /**
     * 根据角色id查询关联的菜单信息id
     */
    @RequestMapping("/findMenuByRoleId")
    public ResponseResult findMenuByRoleId(Integer roleId) {
        List<Integer> list = roleService.findMenuByRoleId(roleId);
        return new ResponseResult(true, 200, "查询角色关联的菜单信息成功", list);
    }

    /**
     * 为角色分配菜单
     */
    @RequestMapping("/RoleContextMenu")
    public ResponseResult RoleContextMenu(@RequestBody RoleMenuVo roleMenuVo) {
        roleService.roleContextMenu(roleMenuVo);
        return new ResponseResult(true, 200, "角色菜单分配成功", null);
    }

    /**
     * 根据角色id查询关联的资源信息id
     */
    @RequestMapping("/findResourceByRoleId")
    public ResponseResult findResourceByRoleId(Integer roleId) {
        List<ResourceCategory> list = roleService.findResourceByRoleId(roleId);
        return new ResponseResult(true, 200, "查询角色关联的资源信息成功", list);
    }


    /**
     * 为角色分配资源
     */
    @RequestMapping("/RoleContextResource")
    public ResponseResult RoleContextResource(@RequestBody RoleResourceVo roleResourceVo) {
        roleService.roleContextResource(roleResourceVo);
        return new ResponseResult(true, 200, "角色资源分配成功", null);
    }

}
