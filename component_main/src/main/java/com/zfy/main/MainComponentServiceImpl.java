package com.zfy.main;

import android.content.Context;
import android.content.Intent;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.march.common.exts.LogX;
import com.zfy.component.basic.service.IComponentService;
import com.zfy.component.biz.Components;

/**
 * CreateAt : 2019/1/25
 * Describe :
 *
 * @author chendong
 */
@Route(path = Components.MAIN_COMPONENT_SERVICE)
public class MainComponentServiceImpl implements IComponentService {

    @Override
    public int priority() {
        return Components.MAIN_COMPONENT_PRIORITY;
    }

    @Override
    public String name() {
        return Components.MAIN_COMPONENT_NAME;
    }

    @Override
    public void redirect(Context context) {
        context.startActivity(new Intent(context, MainActivity.class));
    }

    @Override
    public void init(Context context) {
        LogX.e("chendong", "main init");
    }
}
