package com.ols.course.mapper;

import java.util.List;
import com.ols.course.domain.OlsStudentCourse;
import com.ols.course.domain.vo.StudentCourseListVO;
import org.apache.ibatis.annotations.Param;

/**
 * 选课Mapper接口
 *
 * @author 魏渝辉
 * @date 2022-10-04
 */
public interface OlsStudentCourseMapper
{
    /**
     * 查询选课
     *
     * @param id 选课主键
     * @return 选课
     */
    public OlsStudentCourse selectOlsStudentCourseById(Long id);

    /**
     * 查询选课列表
     *
     * @param olsStudentCourse 选课
     * @return 选课集合
     */
    public List<OlsStudentCourse> selectOlsStudentCourseList(OlsStudentCourse olsStudentCourse);

    /**
     * 查询选课列表
     *
     * @param olsStudentCourse 选课
     * @return 选课集合
     */
    public List<StudentCourseListVO> selectOlsStudentCourseListVO(OlsStudentCourse olsStudentCourse);

    /**
     * 新增选课
     *
     * @param olsStudentCourse 选课
     * @return 结果
     */
    public int insertOlsStudentCourse(OlsStudentCourse olsStudentCourse);

    /**
     * 修改选课
     *
     * @param olsStudentCourse 选课
     * @return 结果
     */
    public int updateOlsStudentCourse(OlsStudentCourse olsStudentCourse);

    /**
     * 删除选课
     *
     * @param id 选课主键
     * @return 结果
     */
    public int deleteOlsStudentCourseById(Long id);

    /**
     * 批量删除选课
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteOlsStudentCourseByIds(Long[] ids);

    /**
     * 退选课程
     * @param id 用户id
     * @param courseId 课程id
     * @return
     */
    public int deleteByCourseIdAndUserId(@Param("id") Long id,@Param("courseId") Long courseId);
}
