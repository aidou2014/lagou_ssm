package com.lagou.domain;

import java.util.List;

/**
 * @author liangchuancan
 * @description
 * @date 2022年02月19日 22:55
 */
public class RoleResourceVo {

    private Integer roleId;

    private List<Integer> resourceIdList;

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public List<Integer> getResourceIdList() {
        return resourceIdList;
    }

    public void setResourceIdList(List<Integer> resourceIdList) {
        this.resourceIdList = resourceIdList;
    }
}
