package com.dianping.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dianping.dto.Result;
import com.dianping.entity.Shop;
import com.dianping.mapper.ShopMapper;
import com.dianping.service.IShopService;
import com.dianping.utils.CacheClient;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import java.util.concurrent.TimeUnit;

import static com.dianping.utils.RedisConstants.CACHE_NULL_TTL;
import static com.dianping.utils.RedisConstants.CACHE_SHOP_KEY;

@Service
public class ShopServiceImpl extends ServiceImpl<ShopMapper, Shop> implements IShopService {

    @Resource
    private CacheClient cacheClient;

    @Override
    public Result queryById(Long id) {
        // 解决缓存穿透
        Shop shop = cacheClient
                .queryWithPassThrough(CACHE_SHOP_KEY, id, Shop.class, this::getById, CACHE_NULL_TTL, TimeUnit.MINUTES);
        if (shop == null) {
            return Result.fail("店铺不存在!");
        }
        // 返回
        return Result.ok(shop);
    }
}
