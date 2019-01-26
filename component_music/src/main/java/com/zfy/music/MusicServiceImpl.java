package com.zfy.music;

import android.content.Context;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.march.common.exts.ToastX;
import com.zfy.component.biz.Components;
import com.zfy.component.biz.music.model.MusicModel;
import com.zfy.component.biz.music.service.MusicService;

/**
 * CreateAt : 2019/1/24
 * Describe :
 *
 * @author chendong
 */
@Route(path = Components.MUSIC_SERVICE)
public class MusicServiceImpl implements MusicService {

    @Override
    public void init(Context context) {

    }


    @Override
    public MusicModel playMusic(MusicModel model) {
        model.setTitle("new title");
        ToastX.show("play music");
        return model;
    }
}
