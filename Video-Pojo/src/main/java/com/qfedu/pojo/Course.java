package com.qfedu.pojo;

import java.util.List;

public class Course {

    private int id;
    private String courseTitle;
    private String courseDesc;
    private int subjectId;

    public Course(int id, String courseTitle, String courseDesc, int subjectId, List<Video> videoList) {
        this.id = id;
        this.courseTitle = courseTitle;
        this.courseDesc = courseDesc;
        this.subjectId = subjectId;
        this.videoList = videoList;
    }

    private List<Video> videoList;

    public List<Video> getVideoList() {
        return videoList;
    }

    public void setVideoList(List<Video> videoList) {
        this.videoList = videoList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public String getCourseDesc() {
        return courseDesc;
    }

    public void setCourseDesc(String courseDesc) {
        this.courseDesc = courseDesc;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", courseTitle='" + courseTitle + '\'' +
                ", courseDesc='" + courseDesc + '\'' +
                ", subjectId=" + subjectId +
                ", videoList=" + videoList +
                '}';
    }

}
