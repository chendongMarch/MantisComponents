package com.zfy.mantis.sample;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.zfy.component.basic.ComponentX;

/**
 * CreateAt : 2019/1/27
 * Describe :
 *
 * @author chendong
 */
public class SchemeFilterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Uri uri = getIntent().getData();
        if (uri != null) {
            ComponentX.route(uri).navigation();
        }
        finish();
    }
}
