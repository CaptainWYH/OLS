package com.ols.course.service.impl;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ols.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ols.course.mapper.OlsCourseMapper;
import com.ols.course.domain.OlsCourse;
import com.ols.course.service.IOlsCourseService;

/**
 * 课程Service业务层处理
 *
 * @author 魏渝辉
 * @date 2022-10-04
 */
@Service
public class OlsCourseServiceImpl extends ServiceImpl<OlsCourseMapper, OlsCourse> implements IOlsCourseService
{
    @Autowired
    private OlsCourseMapper olsCourseMapper;

    /**
     * 查询课程
     *
     * @param id 课程主键
     * @return 课程
     */
    @Override
    public OlsCourse selectOlsCourseById(Long id)
    {
        return olsCourseMapper.selectOlsCourseById(id);
    }

    /**
     * 查询课程列表
     *
     * @param olsCourse 课程
     * @return 课程
     */
    @Override
    public List<OlsCourse> selectOlsCourseList(OlsCourse olsCourse)
    {
        return olsCourseMapper.selectOlsCourseList(olsCourse);
    }

    /**
     * 新增课程
     *
     * @param olsCourse 课程
     * @return 结果
     */
    @Override
    public int insertOlsCourse(OlsCourse olsCourse)
    {
        olsCourse.setCreateTime(DateUtils.getNowDate());
        return olsCourseMapper.insertOlsCourse(olsCourse);
    }

    /**
     * 修改课程
     *
     * @param olsCourse 课程
     * @return 结果
     */
    @Override
    public int updateOlsCourse(OlsCourse olsCourse)
    {
        olsCourse.setUpdateTime(DateUtils.getNowDate());
        return olsCourseMapper.updateOlsCourse(olsCourse);
    }

    /**
     * 批量删除课程
     *
     * @param ids 需要删除的课程主键
     * @return 结果
     */
    @Override
    public int deleteOlsCourseByIds(Long[] ids)
    {
        return olsCourseMapper.deleteOlsCourseByIds(ids);
    }

    /**
     * 删除课程信息
     *
     * @param id 课程主键
     * @return 结果
     */
    @Override
    public int deleteOlsCourseById(Long id)
    {
        return olsCourseMapper.deleteOlsCourseById(id);
    }

    /**
     * 获取我的课程
     * @param id 用户id
     * @return
     */
    @Override
    public List<OlsCourse> getMyCourses(Long id) {
        return olsCourseMapper.getMyCourses(id);
    }
}
