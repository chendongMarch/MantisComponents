package com.zfy.mantis.sample;

import com.march.common.Common;
import com.zfy.component.basic.ComponentX;
import com.zfy.component.basic.app.AppApplication;
import com.zfy.component.biz.Components;

/**
 * CreateAt : 2019/1/24
 * Describe :
 *
 * @author chendong
 */
public class MyApplication extends AppApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        Common.init(this, BuildConfig.class);
        ComponentX.init(this, true, Components.getComponentServiceNames());

    }
}
