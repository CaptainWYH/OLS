package com.ols.course.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ols.course.mapper.OlsStudentCourseMapper;
import com.ols.course.domain.OlsStudentCourse;
import com.ols.course.service.IOlsStudentCourseService;

/**
 * 选课Service业务层处理
 *
 * @author 魏渝辉
 * @date 2022-10-04
 */
@Service
public class OlsStudentCourseServiceImpl implements IOlsStudentCourseService
{
    @Autowired
    private OlsStudentCourseMapper olsStudentCourseMapper;

    /**
     * 查询选课
     *
     * @param id 选课主键
     * @return 选课
     */
    @Override
    public OlsStudentCourse selectOlsStudentCourseById(Long id)
    {
        return olsStudentCourseMapper.selectOlsStudentCourseById(id);
    }

    /**
     * 查询选课列表
     *
     * @param olsStudentCourse 选课
     * @return 选课
     */
    @Override
    public List<OlsStudentCourse> selectOlsStudentCourseList(OlsStudentCourse olsStudentCourse)
    {
        return olsStudentCourseMapper.selectOlsStudentCourseList(olsStudentCourse);
    }

    /**
     * 新增选课
     *
     * @param olsStudentCourse 选课
     * @return 结果
     */
    @Override
    public int insertOlsStudentCourse(OlsStudentCourse olsStudentCourse)
    {
        return olsStudentCourseMapper.insertOlsStudentCourse(olsStudentCourse);
    }

    /**
     * 修改选课
     *
     * @param olsStudentCourse 选课
     * @return 结果
     */
    @Override
    public int updateOlsStudentCourse(OlsStudentCourse olsStudentCourse)
    {
        return olsStudentCourseMapper.updateOlsStudentCourse(olsStudentCourse);
    }

    /**
     * 批量删除选课
     *
     * @param ids 需要删除的选课主键
     * @return 结果
     */
    @Override
    public int deleteOlsStudentCourseByIds(Long[] ids)
    {
        return olsStudentCourseMapper.deleteOlsStudentCourseByIds(ids);
    }

    /**
     * 删除选课信息
     *
     * @param id 选课主键
     * @return 结果
     */
    @Override
    public int deleteOlsStudentCourseById(Long id)
    {
        return olsStudentCourseMapper.deleteOlsStudentCourseById(id);
    }

    /**
     * 退选课程
     * @param id 用户id
     * @param courseId 课程id
     * @return
     */
    @Override
    public int cancelCourse(Long id, Long courseId) {
        return olsStudentCourseMapper.deleteByCourseIdAndUserId(id,courseId);
    }
}
