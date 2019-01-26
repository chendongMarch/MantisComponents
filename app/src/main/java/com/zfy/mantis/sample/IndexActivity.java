package com.zfy.mantis.sample;

import com.zfy.component.basic.ComponentX;
import com.zfy.component.basic.mvx.mvp.app.MvpActivity;
import com.zfy.component.basic.mvx.mvp.app.MvpV;

/**
 * CreateAt : 2019/1/25
 * Describe :
 *
 * @author chendong
 */
@MvpV(layout = R.layout.app_index_activity)
public class IndexActivity extends MvpActivity {

    @Override
    public void init() {
        ComponentX.redirect(getActivity(), BuildConfig.ENTRY);
    }
}
