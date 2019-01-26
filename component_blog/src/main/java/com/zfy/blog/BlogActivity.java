package com.zfy.blog;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.zfy.component.basic.app.view.ViewConfig;
import com.zfy.component.basic.mvx.mvp.app.MvpActivity;
import com.zfy.component.biz.Components;

/**
 * CreateAt : 2019/1/24
 * Describe :
 *
 * @author chendong
 */
@Route(path = Components.BLOG_INDEX_PAGE)
public class BlogActivity extends MvpActivity {

    @Override
    public void init() {

    }

    @Override
    public ViewConfig getViewConfig() {
        return ViewConfig.makeMvp(R.layout.blog_activity, null);
    }
}
