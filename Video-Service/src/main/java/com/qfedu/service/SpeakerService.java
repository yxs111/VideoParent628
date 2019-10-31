package com.qfedu.service;

import com.qfedu.pojo.Speaker;

import java.util.List;

public interface SpeakerService {
    List<Speaker> selectAllSpeaker();
    List<Speaker> selectAllSpeaker(int page, int pageSize);

    boolean deleteSpeakerById(int id);
    int saveOrUpdate(Speaker speaker);
    Speaker findSpeakerById(int id);
}
