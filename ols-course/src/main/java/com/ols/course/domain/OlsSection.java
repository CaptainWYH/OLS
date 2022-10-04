package com.ols.course.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ols.common.annotation.Excel;
import com.ols.common.core.domain.BaseEntity;

/**
 * 章节对象 ols_section
 * 
 * @author 魏渝辉
 * @date 2022-10-04
 */
public class OlsSection extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 课程id */
    @Excel(name = "课程id")
    private Long courseId;

    /** 章节名称 */
    @Excel(name = "章节名称")
    private String sectionName;

    /** 版本号 */
    @Excel(name = "版本号")
    private Long version;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setCourseId(Long courseId) 
    {
        this.courseId = courseId;
    }

    public Long getCourseId() 
    {
        return courseId;
    }
    public void setSectionName(String sectionName) 
    {
        this.sectionName = sectionName;
    }

    public String getSectionName() 
    {
        return sectionName;
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
            .append("courseId", getCourseId())
            .append("sectionName", getSectionName())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("version", getVersion())
            .toString();
    }
}
