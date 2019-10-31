package com.qfedu.service.impl;

import com.github.pagehelper.PageHelper;
import com.qfedu.dao.CourseMapper;
import com.qfedu.pojo.Course;
import com.qfedu.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseMapper courseMapper;

    public List<Course> selectAllCourse(int page, int pageSize) {
        PageHelper.startPage(page,pageSize);
        List<Course> courseList = courseMapper.selectCourseList();
        return courseList;
    }


    public List<Course> selectAllCourse() {
       List<Course>courseList=courseMapper.selectCourseList();
        return courseList;
    }


    public boolean deleteCourseById(int id) {
        int result = courseMapper.deleteCourseById(id);
        return result>0?true:false;
    }


    public int saveOrUpdate(Course course) {
        int result = 0;
        if (course.getId()==0){
            result = courseMapper.insertCourse(course);
        }else {
            result = courseMapper.updateCourse(course);
        }
        return result;

    }


    public Course findCourseById(int id) {
        return  courseMapper.findCourseById(id);

    }

    public List<Course> selectCouseBySubjectId(int subjectId) {
        return courseMapper.selectCouseBySubjectId(subjectId);
    }

    public Course selectCourseById(int courseId) {

        return courseMapper.selectCourseById(courseId);
    }
}
