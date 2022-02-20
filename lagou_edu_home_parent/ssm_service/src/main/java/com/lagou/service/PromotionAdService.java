package com.lagou.service;

import com.github.pagehelper.PageInfo;
import com.lagou.domain.PromotionAd;
import com.lagou.domain.PromotionAdVo;

/**
 * @author liangchuancan
 * @description
 * @date 2022年02月15日 23:02
 */
public interface PromotionAdService {

    // 分页查询广告信息
    public PageInfo<PromotionAd> findAllPromotionAdByPage(PromotionAdVo promotionAdVo);

    // 添加广告
    public void savePromotionAd(PromotionAd promotionAd);

    // 根据id查询对应广告信息
    public PromotionAd findPromotionAdById(int id);

    // 修改广告
    public void updatePromotionAd(PromotionAd promotionAd);

    // 广告动态上下线
    public void updatePromotionAdStatus(Integer id, Integer status);

}
