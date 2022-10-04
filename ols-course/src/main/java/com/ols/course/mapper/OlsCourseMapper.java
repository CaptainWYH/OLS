package com.ols.course.mapper;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ols.course.domain.OlsCourse;

/**
 * 课程Mapper接口
 * 
 * @author 魏渝辉
 * @date 2022-10-04
 */
public interface OlsCourseMapper extends BaseMapper<OlsCourse>
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
     * 删除课程
     * 
     * @param id 课程主键
     * @return 结果
     */
    public int deleteOlsCourseById(Long id);

    /**
     * 批量删除课程
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteOlsCourseByIds(Long[] ids);
}
