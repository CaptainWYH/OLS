package com.ols.course.service;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ols.course.domain.OlsCourse;
import com.ols.course.mapper.OlsCourseMapper;

/**
 * 课程Service接口
 *
 * @author 魏渝辉
 * @date 2022-10-04
 */
public interface IOlsCourseService extends IService<OlsCourse>
{
    /**
     * 查询课程
     *
     * @param id 课程主键
     * @return 课程
     */
    public OlsCourse selectOlsCourseById(Long id);

    /**
     * 查询课程列表
     *
     * @param olsCourse 课程
     * @return 课程集合
     */
    public List<OlsCourse> selectOlsCourseList(OlsCourse olsCourse);

    /**
     * 新增课程
     *
     * @param olsCourse 课程
     * @return 结果
     */
    public int insertOlsCourse(OlsCourse olsCourse);

    /**
     * 修改课程
     *
     * @param olsCourse 课程
     * @return 结果
     */
    public int updateOlsCourse(OlsCourse olsCourse);

    /**
     * 批量删除课程
     *
     * @param ids 需要删除的课程主键集合
     * @return 结果
     */
    public int deleteOlsCourseByIds(Long[] ids);

    /**
     * 删除课程信息
     *
     * @param id 课程主键
     * @return 结果
     */
    public int deleteOlsCourseById(Long id);

    /**
     * 获取我的课程
     * @param id
     * @return
     */
    public List<OlsCourse> getMyCourses(Long id);
}
