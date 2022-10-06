package com.ols.course.domain;

import java.math.BigDecimal;
import java.util.Objects;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ols.common.annotation.Excel;
import com.ols.common.core.domain.BaseEntity;
import org.springframework.data.annotation.Id;

/**
 * 课程对象 ols_course
 *
 * @author 魏渝辉
 * @date 2022-10-04
 */
@TableName("ols_course")
public class OlsCourse extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    @TableId(value = "id",type = IdType.AUTO)
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    /** 课程编码 */
    @Excel(name = "课程编码")
    @TableField("course_code")
    private String courseCode;

    /** 课程名称 */
    @Excel(name = "课程名称")
    @TableField("course_name")
    private String courseName;

    /** 课程学分 */
    @Excel(name = "课程学分")
    @TableField("course_credit")
    private BigDecimal courseCredit;

    /** 版本号 */
    @Excel(name = "版本号")
    @TableField("version")
    private Long version;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setCourseCode(String courseCode)
    {
        this.courseCode = courseCode;
    }

    public String getCourseCode()
    {
        return courseCode;
    }
    public void setCourseName(String courseName)
    {
        this.courseName = courseName;
    }

    public String getCourseName()
    {
        return courseName;
    }
    public void setCourseCredit(BigDecimal courseCredit)
    {
        this.courseCredit = courseCredit;
    }

    public BigDecimal getCourseCredit()
    {
        return courseCredit;
    }
    public void setVersion(Long version)
    {
        this.version = version;
    }

    public Long getVersion()
    {
        return version;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("courseCode", getCourseCode())
            .append("courseName", getCourseName())
            .append("courseCredit", getCourseCredit())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("version", getVersion())
            .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OlsCourse)) return false;

        OlsCourse olsCourse = (OlsCourse) o;

        if (!Objects.equals(id, olsCourse.id)) return false;
        if (!Objects.equals(courseCode, olsCourse.courseCode)) return false;
        if (!Objects.equals(courseName, olsCourse.courseName)) return false;
        if (!Objects.equals(courseCredit, olsCourse.courseCredit))
            return false;
        return Objects.equals(version, olsCourse.version);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (courseCode != null ? courseCode.hashCode() : 0);
        result = 31 * result + (courseName != null ? courseName.hashCode() : 0);
        result = 31 * result + (courseCredit != null ? courseCredit.hashCode() : 0);
        result = 31 * result + (version != null ? version.hashCode() : 0);
        return result;
    }
}
