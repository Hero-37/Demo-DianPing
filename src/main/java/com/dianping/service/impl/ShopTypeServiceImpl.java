package com.dianping.service.impl;

import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dianping.dto.Result;
import com.dianping.entity.ShopType;
import com.dianping.mapper.ShopTypeMapper;
import com.dianping.service.IShopTypeService;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ShopTypeServiceImpl extends ServiceImpl<ShopTypeMapper, ShopType> implements IShopTypeService {

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public Result queryTypeZSet() {
        String key = "cache:typeZSet:";

        // 1.从 redis 查询商铺类型缓存
        String shopTypeString = stringRedisTemplate.opsForZSet().randomMember(key);

        // 2.判断是否存在
        if (StrUtil.isNotBlank(shopTypeString)) {
            // 3.存在，直接返回
            return Result.ok(JSONUtil.toList(shopTypeString, ShopType.class));
        }

        // 4.不存在，查询数据库
        List<ShopType> shopTypeList = query().orderByAsc("sort").list();

        // 5.不存在，返回错误
        if (shopTypeList == null || shopTypeList.size() == 0) {
            return Result.fail("商铺类型为空！！！");
        }

        // 6.存在，将结果写入redis
        stringRedisTemplate.opsForZSet().add(key, JSONUtil.toJsonStr(shopTypeList), 0);

        // 7. 返回
        return Result.ok(shopTypeList);
    }
}
