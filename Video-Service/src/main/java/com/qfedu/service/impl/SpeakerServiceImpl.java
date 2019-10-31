package com.qfedu.service.impl;

import com.github.pagehelper.PageHelper;
import com.qfedu.dao.SpeakerMapper;
import com.qfedu.pojo.Speaker;
import com.qfedu.service.SpeakerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SpeakerServiceImpl implements SpeakerService {

   @Autowired
    private SpeakerMapper speakerMapper;

    public List<Speaker> selectAllSpeaker() {

        List<Speaker> speakerList = speakerMapper.selectAllSpeaker();

        System.out.println(speakerList);
        return speakerList;
    }


    public List<Speaker> selectAllSpeaker(int page, int pageSize) {

        PageHelper.startPage(page,pageSize);
        List<Speaker> speakerList = speakerMapper.selectAllSpeaker();
        return speakerList;
    }


    public boolean deleteSpeakerById(int id) {
        int result = speakerMapper.deleteSpeakerById(id);
        return  result>0?true:false;
    }


    public int saveOrUpdate(Speaker speaker) {
        int id=0;
        if (speaker.getId()!=0){
            speakerMapper.updateSpeaker(speaker);
        }else {
            speakerMapper.insertSpeaker(speaker);
        }

        return id;
    }

    public Speaker findSpeakerById(int id) {
        return speakerMapper.findSpeakerById(id);
    }
}
