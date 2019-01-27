package com.zfy.mantis.sample;

import android.content.Context;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Interceptor;
import com.alibaba.android.arouter.facade.callback.InterceptorCallback;
import com.alibaba.android.arouter.facade.template.IInterceptor;
import com.march.common.x.LogX;
import com.zfy.component.basic.ComponentX;
import com.zfy.component.biz.common.Switchs;

/**
 * CreateAt : 2019/1/27
 * Describe :
 *
 * @author chendong
 */
@Interceptor(priority = 10, name = "测试拦截")
public class TestInterceptorImpl implements IInterceptor {
    public static final String TAG = TestInterceptorImpl.class.getSimpleName();

    @Override
    public void process(Postcard postcard, InterceptorCallback callback) {
        boolean login = ComponentX.extraSign(postcard.getExtra(), Switchs.LOGIN);
        LogX.e(TAG, "发现一次跳转, 需要登录？ " + login);
        callback.onContinue(postcard);
    }

    @Override
    public void init(Context context) {

    }
}
