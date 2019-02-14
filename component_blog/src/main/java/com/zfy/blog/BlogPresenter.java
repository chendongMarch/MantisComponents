package com.zfy.blog;

import com.march.common.x.LogX;
import com.zfy.component.basic.mvx.model.AppRepository;
import com.zfy.component.basic.mvx.mvp.IMvpView;
import com.zfy.component.basic.mvx.mvp.presenter.MvpPresenter;
import com.zfy.component.biz.Components;
import com.zfy.component.biz.blog.model.BlogModel;
import com.zfy.component.biz.blog.service.BlogService;
import com.zfy.mantis.annotation.LookUp;

/**
 * CreateAt : 2019/1/29
 * Describe :
 *
 * @author chendong
 */
public class BlogPresenter extends MvpPresenter<AppRepository, IMvpView> {

    public static final String TAG = BlogPresenter.class.getSimpleName();

    // 传递 key = name 的 String
    @LookUp("name")
    String      name;
    // 传递 key = age 的 int
    @LookUp("age")
    int         newAge;
    // 传递 BlogModel 对象
    @LookUp("model")
    BlogModel   blogModel;
    @LookUp(Components.BLOG_SERVICE)
    BlogService mBlogService;

    @Override
    public void init() {
        LogX.e(TAG, "name = " + name);
        LogX.e(TAG, "age = " + newAge);
        if (blogModel != null) {
            LogX.e(TAG, "model = " + blogModel.getContent());
        } else {
            LogX.e(TAG, "model = " + null);
        }
        if (mBlogService != null) {
            LogX.e(TAG, "music service ok" + mBlogService.getBlogContent(new BlogModel()));
        } else {
            LogX.e(TAG, "music service  = null");
        }
    }
}
