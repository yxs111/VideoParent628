package com.qfedu.service.impl;

import com.qfedu.dao.VideoMapper;
import com.qfedu.pojo.Video;
import com.qfedu.pojo.VideoQueryVo;
import com.qfedu.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class VideoServiceImpl implements VideoService {
@Autowired
private VideoMapper videoMapper;


    public List<Video> selectVideoList(VideoQueryVo videoQueryVo) {
//        SqlSession sqlSession = MybatisUtils.getSqlSessionFactory().openSession();
//        VideoMapper videoMapper = sqlSession.getMapper(VideoMapper.class);
//        //videoQueryVo.setTitle("%"+videoQueryVo.getTitle()+"%");
        List<Video> videos = videoMapper.selectVideoList(videoQueryVo);
//        sqlSession.close();
        videoMapper.selectVideoList(videoQueryVo);
        return videos;
    }


    public void batchDeleteVideos(Integer[] ids) {


        VideoQueryVo videoQueryVo =new VideoQueryVo();
        List<Integer> integers = Arrays.asList(ids);
        videoQueryVo.setIdList(integers);

        videoMapper.batchDeleteVideos(videoQueryVo);


    }


    public boolean delVideoById(int id) {

//       return videoMapper.delVideoById(id);
//        sqlSession.commit();//新增，修改，删除才需要commit
//        sqlSession.close();
        int a = videoMapper.delVideoById(id);

        return a > 0 ? true:false;
    }


    public Video findById(int id) {

        return videoMapper.findById(id);
    }


    public int saveOrUpdate(Video video) {

        int id=0;
        if (video.getId()!=0){
            videoMapper.updateVideo(video);
            id=video.getId();
        }else {
            videoMapper.insertVideo(video);
            id =  video.getId();
        }

        return id;
    }


    public int getCount(VideoQueryVo videoQueryVo) {

        int  result = videoMapper.getCount(videoQueryVo);
        return result ;
    }

    public List<Video> selectVideoListByCourseId(int id) {
        return videoMapper.selectVideoListByCourseId(id);
    }
}
