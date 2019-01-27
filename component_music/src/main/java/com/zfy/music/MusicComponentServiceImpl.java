package com.zfy.music;

import android.content.Context;
import android.content.Intent;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.march.common.x.LogX;
import com.zfy.component.basic.service.IComponentService;
import com.zfy.component.biz.Components;

/**
 * CreateAt : 2019/1/25
 * Describe :
 *
 * @author chendong
 */
@Route(path = Components.MUSIC_COMPONENT_SERVICE)
public class MusicComponentServiceImpl implements IComponentService {

    @Override
    public int priority() {
        return Components.MUSIC_COMPONENT_PRIORITY;
    }

    @Override
    public String name() {
        return Components.MUSIC_COMPONENT_NAME;
    }

    @Override
    public void redirect(Context context) {
        context.startActivity(new Intent(context, MusicActivity.class));
    }

    @Override
    public void init(Context context) {
        LogX.e("chendong", "music init");
    }
}
