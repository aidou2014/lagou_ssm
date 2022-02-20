package com.lagou.dao;

import com.lagou.domain.ResourceCategory;

import java.util.List;

/**
 * @author liangchuancan
 * @description
 * @date 2022年02月19日 17:46
 */
public interface ResourceCategoryMapper {

    // 查询所有资源分类
    public List<ResourceCategory> findAllResourceCategory();

    // 添加资源分类
    public void saveResourceCategory(ResourceCategory resourceCategory);

    // 修改资源分类
    public void updateResourceCategory(ResourceCategory resourceCategory);

    // 删除资源分类
    public void deleteResourceCategory(Integer rid);

    // 依据资源分类id删除对应的资源信息
    public void deleteResourceCategoryContextResource(Integer rid);
}
