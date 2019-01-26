package com.zfy.component.biz.blog.service;

import com.zfy.component.basic.service.IService;
import com.zfy.component.biz.blog.model.BlogModel;

/**
 * CreateAt : 2019/1/24
 * Describe :
 *
 * @author chendong
 */
public interface BlogService extends IService {
    String getBlogContent(BlogModel model);
}
