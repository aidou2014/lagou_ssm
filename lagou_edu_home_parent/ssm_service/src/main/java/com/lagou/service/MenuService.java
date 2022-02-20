package com.lagou.service;

import com.lagou.domain.Menu;

import java.util.List;

/**
 * @author liangchuancan
 * @description
 * @date 2022年02月19日 10:01
 */
public interface MenuService {

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

    // 删除菜单
    public void deleteMenu(Integer id);

}
