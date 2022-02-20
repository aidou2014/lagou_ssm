package com.lagou.dao;

import com.lagou.domain.Test;

import java.util.List;

/**
 * @author liangchuancan
 * @description
 * @date 2022年01月17日 22:12
 */
public interface TestMapper {

    /**
     * 查询test表的所有数据
     *
     * @return 列表
     */
    public List<Test> findAllTest();


}
