package com.zfy.main;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.march.common.x.ToastX;
import com.zfy.component.basic.ComponentX;
import com.zfy.component.basic.app.view.ViewConfig;
import com.zfy.component.basic.mvx.mvp.app.MvpActivity;
import com.zfy.component.biz.Components;
import com.zfy.component.biz.blog.model.BlogModel;
import com.zfy.component.biz.blog.service.BlogService;
import com.zfy.component.biz.common.Keys;
import com.zfy.component.biz.music.model.MusicModel;
import com.zfy.component.biz.music.service.MusicService;

@Route(path = Components.MAIN_INDEX_PAGE)
public class MainActivity extends MvpActivity {

    @Override
    public void init() {
        ToastX.show("init");
        getAppDelegate().setOnClickListener(view -> {
            if (view.getId() == R.id.blog_page_btn) {
                ComponentX.route(Components.BLOG_INDEX_PAGE)
                        .withString("name", "I am Name")
                        .withInt("age", 100)
                        .withParcelable("model", new BlogModel("传递的 blogModel"))
                        .navigation(getContext());

            } else if (view.getId() == R.id.music_page_btn) {
                ComponentX.route(Components.MUSIC_INDEX_PAGE)
                        .withString(Keys.KEY_TEST, "test")
                        .navigation(getContext());
            } else if (view.getId() == R.id.blog_service_btn) {
                ComponentX.service(BlogService.class, service -> {
                    String blogContent = service.getBlogContent(new BlogModel());
                    ToastX.show(blogContent);
                });
            } else if (view.getId() == R.id.music_service_btn) {
                ComponentX.service(Components.MUSIC_SERVICE, MusicService.class, service -> {
                    service.playMusic(new MusicModel());
                });
            }

        }, R.id.blog_page_btn, R.id.music_page_btn, R.id.blog_service_btn, R.id.music_service_btn);
    }

    @Override
    public ViewConfig getViewConfig() {
        return ViewConfig.makeMvp(R.layout.activity_main, null);
    }
}
