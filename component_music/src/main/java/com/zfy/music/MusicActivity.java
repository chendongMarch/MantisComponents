package com.zfy.music;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.zfy.component.basic.ComponentX;
import com.zfy.component.basic.app.view.ViewConfig;
import com.zfy.component.basic.mvx.mvp.app.MvpActivity;
import com.zfy.component.biz.Components;

/**
 * CreateAt : 2019/1/24
 * Describe :
 *
 * @author chendong
 */
@Route(path = Components.MUSIC_INDEX_PAGE)
public class MusicActivity extends MvpActivity {

    @Override
    public void init() {
        getAppDelegate().setOnClickListener(v->{
            ComponentX.go(getContext(), Components.BLOG_INDEX_PAGE);
        },R.id.blog_btn);
    }

    @Override
    public ViewConfig getViewConfig() {
        return ViewConfig.makeMvp(R.layout.music_activity, null);
    }
}
