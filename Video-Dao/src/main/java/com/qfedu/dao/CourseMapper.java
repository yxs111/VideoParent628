package com.qfedu.dao;

import com.qfedu.pojo.Course;

import java.util.List;

public interface CourseMapper {
    List<Course> selectCourseList();

    int deleteCourseById(int id);

    int insertCourse(Course course);

    int updateCourse(Course course);

    Course findCourseById(int id);

    List<Course> selectCouseBySubjectId(int subjectId);

    Course selectCourseById(int courseId);
}
