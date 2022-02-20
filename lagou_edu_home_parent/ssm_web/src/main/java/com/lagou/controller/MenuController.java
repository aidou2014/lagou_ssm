package com.lagou.controller;

import com.lagou.domain.Menu;
import com.lagou.domain.ResponseResult;
import com.lagou.service.MenuService;
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
 * @date 2022年02月19日 10:02
 */
@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    /**
     * 查询所有菜单信息
     */
    @RequestMapping("/findAllMenu")
    public ResponseResult findAllMenu() {
        List<Menu> allMenu = menuService.findAllMenu();
        return new ResponseResult(true, 200, "查询所有菜单信息成功", allMenu);
    }

    /**
     * 新增&修改时回显菜单信息
     */
    @RequestMapping("/findMenuInfoById")
    public ResponseResult findMenuInfoById(Integer id) {
        // 如果是新增菜单,则id值为 -1, 修改菜单 则为当前选择的id值
        if (id == -1) {
            // 添加操作 回显信息中不需要查询menu的信息
            List<Menu> menuList = menuService.findSubMenuListByPid(-1);
            // 封装数据
            Map<String, Object> map = new HashMap<>(16);
            map.put("menuInfo", null);
            map.put("parentMenuList", menuList);
            return new ResponseResult(true, 200, "添加回显成功", map);
        } else {
            // 修改操作 回显信息中需要查询menu的信息
            Menu menu = menuService.findMenuInfoById(id);
            List<Menu> menuList = menuService.findSubMenuListByPid(-1);
            // 封装数据
            Map<String, Object> map = new HashMap<>(16);
            map.put("menuInfo", menu);
            map.put("parentMenuList", menuList);
            return new ResponseResult(true, 200, "修改回显成功", map);
        }
    }

    /**
     * 新增&修改菜单信息
     */
    @RequestMapping("/saveOrUpdateMenu")
    public ResponseResult saveOrUpdateMenu(@RequestBody Menu menu) {
        if (menu.getId() != null) {
            menuService.updateMenu(menu);
            return new ResponseResult(true, 200, "修改菜单成功", null);
        } else {
            menuService.saveMenu(menu);
            return new ResponseResult(true, 200, "新增菜单成功", null);
        }
    }

    /**
     * 删除菜单
     */
    @RequestMapping("/deleteMenu")
    public ResponseResult deleteMenu(Integer id) {
        menuService.deleteMenu(id);
        return new ResponseResult(true, 200, "删除菜单成功", null);
    }

}
