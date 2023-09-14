package com.dianping.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dianping.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserInfoMapper extends BaseMapper<UserInfo> {
}
