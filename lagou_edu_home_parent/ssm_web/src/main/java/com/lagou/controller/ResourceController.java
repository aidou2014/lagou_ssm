package com.lagou.controller;

import com.github.pagehelper.PageInfo;
import com.lagou.domain.Resource;
import com.lagou.domain.ResourceVo;
import com.lagou.domain.ResponseResult;
import com.lagou.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liangchuancan
 * @description
 * @date 2022年02月19日 16:01
 */
@RestController
@RequestMapping("/resource")
public class ResourceController {

    @Autowired
    private ResourceService resourceService;

    /**
     * 分页&多条件查询资源
     */
    @RequestMapping("/findAllResource")
    public ResponseResult findAllResourceByPage(@RequestBody ResourceVo resourceVo) {
        PageInfo<Resource> pageInfo = resourceService.findAllResourceByPage(resourceVo);
        return new ResponseResult(true, 200, "分页多条件查询资源成功", pageInfo);
    }

    /**
     * 新增&更新资源
     */
    @RequestMapping("/saveOrUpdateResource")
    public ResponseResult saveOrUpdateResource(@RequestBody Resource resource) {
        if (resource.getId() != null) {
            resourceService.updateResource(resource);
            return new ResponseResult(true, 200, "更新资源成功", null);
        } else {
            resourceService.saveResource(resource);
            return new ResponseResult(true, 200, "新增资源成功", null);
        }
    }

    /**
     * 删除资源
     */
    @RequestMapping("/deleteResource")
    public ResponseResult deleteResource(Integer id) {
        resourceService.deleteResource(id);
        return new ResponseResult(true, 200, "删除资源成功", null);
    }


}
