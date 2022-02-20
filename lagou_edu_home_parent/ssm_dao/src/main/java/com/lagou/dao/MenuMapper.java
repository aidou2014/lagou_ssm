package com.lagou.dao;

import com.lagou.domain.Menu;

import java.util.List;

/**
 * @author liangchuancan
 * @description
 * @date 2022年02月19日 9:48
 */
public interface MenuMapper {

    // 查询父子菜单信息
    public List<Menu> findSubMenuListByPid(int pid);

    // 查询所有菜单列表
    public List<Menu> findAllMenu();

    // 依据菜单id查询菜单信息
    public Menu findMenuInfoById(Integer id);

    // 新增菜单
    public void saveMenu(Menu menu);

    // 更新菜单
    public void updateMenu(Menu menu);

    // 根据menuId清空中间表的关联关系
    public void deleteRoleContextMenu(Integer mid);

    // 删除菜单
    public void deleteMenu(Integer mid);

}
