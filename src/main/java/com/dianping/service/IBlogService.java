package com.dianping.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dianping.dto.Result;
import com.dianping.entity.Blog;

public interface IBlogService extends IService<Blog> {
    Result queryHotBlog(Integer current);

    Result queryBlogById(Long id);
}
