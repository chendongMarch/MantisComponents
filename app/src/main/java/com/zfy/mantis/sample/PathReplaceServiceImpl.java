package com.zfy.mantis.sample;

import android.content.Context;
import android.net.Uri;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.facade.service.PathReplaceService;
import com.zfy.component.basic.service.BasicServices;

@Route(path = BasicServices.PATH_REWRITE_SERVICE)
public class PathReplaceServiceImpl implements PathReplaceService {

    @Override
    public String forString(String path) {
        return path;
    }

    @Override
    public Uri forUri(Uri uri) {
        return uri;
    }

    @Override
    public void init(Context context) {

    }
}