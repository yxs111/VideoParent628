package com.qfedu.dao;

import com.qfedu.pojo.Speaker;

import java.util.List;

public interface SpeakerMapper {

    List<Speaker> selectAllSpeaker();
    int deleteSpeakerById(int id);
    void insertSpeaker(Speaker speaker);
    void updateSpeaker(Speaker speaker);
    Speaker findSpeakerById(int id);
}
