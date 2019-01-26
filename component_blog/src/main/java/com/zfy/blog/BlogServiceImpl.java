package com.zfy.blog;

import android.content.Context;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.zfy.component.biz.Components;
import com.zfy.component.biz.blog.model.BlogModel;
import com.zfy.component.biz.blog.service.BlogService;

/**
 * CreateAt : 2019/1/24
 * Describe :
 *
 * @author chendong
 */
@Route(path = Components.BLOG_SERVICE)
public class BlogServiceImpl implements BlogService {

    @Override
    public void init(Context context) {

    }

    @Override
    public String getBlogContent(BlogModel model) {
        return "我是 blog content";
    }
}
