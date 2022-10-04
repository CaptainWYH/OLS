package com.ols.course.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ols.common.annotation.Excel;
import com.ols.common.core.domain.BaseEntity;

/**
 * 选课对象 ols_student_course
 * 
 * @author 魏渝辉
 * @date 2022-10-04
 */
public class OlsStudentCourse extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 学生id */
    @Excel(name = "学生id")
    private Long studnetId;

    /** 课程id */
    @Excel(name = "课程id")
    private Long courseId;

    /** 取得学分 */
    @Excel(name = "取得学分")
    private BigDecimal courseCredit;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setStudnetId(Long studnetId) 
    {
        this.studnetId = studnetId;
    }

    public Long getStudnetId() 
    {
        return studnetId;
    }
    public void setCourseId(Long courseId) 
    {
        this.courseId = courseId;
    }

    public Long getCourseId() 
    {
        return courseId;
    }
    public void setCourseCredit(BigDecimal courseCredit) 
    {
        this.courseCredit = courseCredit;
    }

    public BigDecimal getCourseCredit() 
    {
        return courseCredit;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("studnetId", getStudnetId())
            .append("courseId", getCourseId())
            .append("courseCredit", getCourseCredit())
            .toString();
    }
}
