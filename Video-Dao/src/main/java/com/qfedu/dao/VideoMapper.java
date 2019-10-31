package com.qfedu.dao;

import com.qfedu.pojo.Video;
import com.qfedu.pojo.VideoQueryVo;

import java.util.List;

public interface VideoMapper {
    List<Video> selectVideoList(VideoQueryVo videoQueryVo);

    void batchDeleteVideos(VideoQueryVo videoQueryVo);
    int delVideoById(int id);
    void insertVideo(Video video);
    Video findById(int id);
    void updateVideo(Video video);
    int getCount(VideoQueryVo videoQueryVo);

    List<Video> selectVideoListByCourseId(int id);
}
