package com.lagou.domain;

import java.util.List;

/**
 * @author liangchuancan
 * @description
 * @date 2022年02月19日 11:25
 */
public class RoleMenuVo {

    private Integer roleId;

    private List<Integer> menuIdList;

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public List<Integer> getMenuIdList() {
        return menuIdList;
    }

    public void setMenuIdList(List<Integer> menuIdList) {
        this.menuIdList = menuIdList;
    }
}
