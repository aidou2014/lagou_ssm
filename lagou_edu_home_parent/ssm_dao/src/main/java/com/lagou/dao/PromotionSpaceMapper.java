package com.lagou.dao;

import com.lagou.domain.PromotionSpace;

import java.util.List;

/**
 * @author liangchuancan
 * @description
 * @date 2022年02月14日 22:01
 */
public interface PromotionSpaceMapper {

    // 获取所有广告位列表
    public List<PromotionSpace> findAllPromotionSpace();

    // 添加广告位
    public void savePromotionSpace(PromotionSpace promotionSpace);

    // 根据id查询对应广告位信息
    public PromotionSpace findPromotionSpaceById(int id);

    // 修改广告位
    public void updatePromotionSpace(PromotionSpace promotionSpace);

}
