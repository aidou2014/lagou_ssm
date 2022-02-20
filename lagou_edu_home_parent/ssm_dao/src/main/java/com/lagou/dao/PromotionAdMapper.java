package com.lagou.dao;

import com.lagou.domain.PromotionAd;

import java.util.List;

/**
 * @author liangchuancan
 * @description
 * @date 2022年02月15日 22:13
 */
public interface PromotionAdMapper {

    // 分页查询广告信息
    public List<PromotionAd> findAllPromotionAdByPage();

    // 添加广告
    public void savePromotionAd(PromotionAd promotionAd);

    // 根据id查询对应广告信息
    public PromotionAd findPromotionAdById(int id);

    // 修改广告
    public void updatePromotionAd(PromotionAd promotionAd);

    // 广告动态上下线
    public void updatePromotionAdStatus(PromotionAd promotionAd);

}
