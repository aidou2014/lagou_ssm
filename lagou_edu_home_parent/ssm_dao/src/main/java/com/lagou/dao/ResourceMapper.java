package com.lagou.dao;

import com.lagou.domain.Resource;
import com.lagou.domain.ResourceVo;

import java.util.List;

/**
 * @author liangchuancan
 * @description
 * @date 2022年02月19日 15:50
 */
public interface ResourceMapper {

    // 资源分页&多条件查询
    public List<Resource> findAllResourceByPage(ResourceVo resourceVo);

    // 添加资源
    public void saveResource(Resource resource);

    // 修改资源
    public void updateResource(Resource resource);

    // 删除资源
    public void deleteResource(Integer rid);


}
