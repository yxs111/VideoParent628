package com.qfedu.service;

import com.qfedu.pojo.Video;
import com.qfedu.pojo.VideoQueryVo;

import java.util.List;

public interface VideoService {
    List<Video> selectVideoList(VideoQueryVo videoQueryVo);

    void batchDeleteVideos(Integer[] ids);
    boolean delVideoById(int id);
    Video findById(int id);
    int saveOrUpdate(Video video);
    int getCount(VideoQueryVo videoQueryVo);

    List<Video> selectVideoListByCourseId(int id);
}
