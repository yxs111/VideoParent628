package com.qfedu.service;

import com.qfedu.pojo.Course;

import java.util.List;

public interface CourseService {
    List<Course> selectAllCourse(int page, int pageSize);
    List<Course> selectAllCourse();

    boolean deleteCourseById(int id);

    int saveOrUpdate(Course course);

    Course findCourseById(int id);

    List<Course>selectCouseBySubjectId(int subjectId);

    Course selectCourseById(int courseId);
}
