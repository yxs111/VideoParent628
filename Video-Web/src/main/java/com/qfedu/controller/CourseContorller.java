package com.qfedu.controller;

import com.github.pagehelper.PageInfo;
import com.qfedu.pojo.Course;
import com.qfedu.pojo.Subject;
import com.qfedu.pojo.Video;
import com.qfedu.service.CourseService;
import com.qfedu.service.SubjectService;
import com.qfedu.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Administrator on 2019/6/25.
 */
@Controller
@RequestMapping("/course")
public class CourseContorller {
    @Autowired
    private CourseService courseService;
    @Autowired
    private VideoService videoService;
    @Autowired
    private SubjectService subjectService;
    @RequestMapping("/list2")
    public String list(Model model, @RequestParam(name = "page",required = false,defaultValue = "1")int page ,@RequestParam(name = "pageSize",required = false,defaultValue = "5") int pageSize){
        List<Course>courseList=courseService.selectAllCourse(page,pageSize);
        PageInfo<Course>pageInfo=new PageInfo<Course>(courseList);
        model.addAttribute("pageInfo" ,pageInfo);
        return "behind/courseList";
    }
    @RequestMapping("/deleteCourseById")
    @ResponseBody
    public String deleteCourseById(int id){
        boolean result=courseService.deleteCourseById(id);
        if (result){
            return "success";
        }else {
            return "";
        }
    }
    @RequestMapping("saveOrUpdate")
    public String saveOrUpdate (Course course){
        System.out.println(course);
        int i = courseService.saveOrUpdate(course);
        System.out.println(i);
        return "redirect:/course/list2";
    }
    @RequestMapping("/insertCourse")
    public String insertCourse(){
        System.out.println("新增============");
        return "behind/addCourse";
    }
    @RequestMapping("/updateCourse")
    public String updateCourse(Model model, int id){
        System.out.println("修改============");
        Course course = courseService.findCourseById(id);
        System.out.println(course);
        model.addAttribute("course",course);
        return "behind/addCourse";
    }
    @RequestMapping("/list")
    public String showList(int subjectId,Model model){
        Subject subject = subjectService.selectSubjectById(subjectId);
        List<Course>courseList = courseService.selectCouseBySubjectId(subjectId);
        subject.setCourseList(courseList);
        for (Course course : courseList){
             List<Video> videoList =videoService.selectVideoListByCourseId(course.getId());
            course.setVideoList(videoList);
        }

        model.addAttribute("subject",subject);
        return "before/course";

    }
}
