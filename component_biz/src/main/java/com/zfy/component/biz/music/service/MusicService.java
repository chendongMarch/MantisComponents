package com.zfy.component.biz.music.service;

import com.zfy.component.basic.service.IService;
import com.zfy.component.biz.music.model.MusicModel;

/**
 * CreateAt : 2019/1/24
 * Describe :
 *
 * @author chendong
 */
public interface MusicService extends IService {
    MusicModel playMusic(MusicModel model);
}
