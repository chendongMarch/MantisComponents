package com.zfy.blog;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.march.common.x.LogX;
import com.zfy.component.basic.app.view.ViewConfig;
import com.zfy.component.basic.mvx.mvp.app.MvpActivity;
import com.zfy.component.biz.Components;
import com.zfy.component.biz.blog.model.BlogModel;

/**
 * CreateAt : 2019/1/24
 * Describe :
 *
 * @author chendong
 */
@Route(path = Components.BLOG_INDEX_PAGE, extras = Components.BLOG_PAGE_EXTRA)
public class BlogActivity extends MvpActivity {

    public static final String TAG = BlogActivity.class.getSimpleName();

    // 传递 key = name 的 String
    @Autowired
    String    name;
    // 传递 key = age 的 int
    @Autowired(name = "age")
    int       newAge;
    // 传递 BlogModel 对象
    @Autowired(name = "model")
    BlogModel blogModel;


    @Override
    public void init() {
        LogX.e(TAG, "name = " + name);
        LogX.e(TAG, "age = " + newAge);
        if (blogModel != null) {
            LogX.e(TAG, "model = " + blogModel.getContent());
        } else {
            LogX.e(TAG, "model = " + null);

        }
    }

    @Override
    public ViewConfig getViewConfig() {
        return ViewConfig.makeMvp(R.layout.blog_activity, null);
    }
}
