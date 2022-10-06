package com.ols.course.controller;


import com.ols.common.core.controller.BaseController;
import com.ols.common.core.domain.AjaxResult;
import com.ols.course.service.IOlsCourseService;
import com.ols.course.service.IOlsStudentCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
     * 选课
     */
    @GetMapping("/choseList")
    public AjaxResult choseList(){

        return null;
    }

}
