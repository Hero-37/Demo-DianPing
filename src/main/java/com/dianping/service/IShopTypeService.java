package com.dianping.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dianping.dto.Result;
import com.dianping.entity.ShopType;

public interface IShopTypeService extends IService<ShopType> {

    public Result queryTypeZSet();
}
