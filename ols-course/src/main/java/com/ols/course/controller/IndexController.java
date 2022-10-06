package com.ols.course.controller;


import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.ols.common.core.controller.BaseController;
import com.ols.common.core.domain.AjaxResult;
import com.ols.course.domain.OlsStudentCourse;
import com.ols.course.service.IOlsCourseService;
import com.ols.course.service.IOlsStudentCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ols-course/index")
public class IndexController extends BaseController {

    @Autowired
    private IOlsStudentCourseService olsStudentCourseService;

    @Autowired
    private IOlsCourseService olsCourseService;

    /**
     * 获取我的课程
     */
    @GetMapping("/myCourses")
    public AjaxResult myCourses(){

        return AjaxResult.success(olsCourseService.getMyCourses(getUserId()));
    }

    /**
     * 获取选课列表
     */
    @GetMapping("/choseList")
    public AjaxResult choseList(){

        return AjaxResult.success(olsCourseService.getNotChoseCourse(this.getUserId()));
    }

    /**
     * 退选课程
     */
    @DeleteMapping("/cancel/{courseId}")
    public AjaxResult cancel(@PathVariable("courseId") Long courseId){
        return toAjax(olsStudentCourseService.cancelCourse(this.getUserId(),courseId));
    }

    /**
     * 加入学习课程
     */
    @GetMapping("/chose/{courseId}")
    public AjaxResult chose(@PathVariable("courseId") Long courseId){
        OlsStudentCourse olsStudentCourse = new OlsStudentCourse();
        olsStudentCourse.setId(IdWorker.getId());
        olsStudentCourse.setStudnetId(this.getUserId());
        olsStudentCourse.setCourseId(courseId);
        return toAjax(olsStudentCourseService.insertOlsStudentCourse(olsStudentCourse));
    }
}
