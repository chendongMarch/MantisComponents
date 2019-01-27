package com.zfy.mantis.sample;

import android.content.Context;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.facade.service.DegradeService;
import com.march.common.x.LogX;
import com.zfy.component.basic.service.BasicServices;

/**
 * CreateAt : 2019/1/27
 * Describe :
 *
 * @author chendong
 */
@Route(path = BasicServices.DEGRADE_SERVICE)
public class TestDegradeServiceImpl implements DegradeService {

    @Override
    public void onLost(Context context, Postcard postcard) {
        LogX.e("chendong", "DegradeService onLost");
    }

    @Override
    public void init(Context context) {

    }
}
