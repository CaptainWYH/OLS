package com.ols.course.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ols.common.annotation.Excel;
import com.ols.common.core.domain.BaseEntity;

/**
 * 进度对象 ols_progress
 * 
 * @author 魏渝辉
 * @date 2022-10-04
 */
public class OlsProgress extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 媒体id */
    @Excel(name = "媒体id")
    private Long mediaId;

    /** 学生id */
    @Excel(name = "学生id")
    private Long studentId;

    /** 进度状态：0.0% 1.33.3% 2.66.6% 3.100% */
    @Excel(name = "进度状态：0.0% 1.33.3% 2.66.6% 3.100%")
    private Integer progressStatus;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setMediaId(Long mediaId) 
    {
        this.mediaId = mediaId;
    }

    public Long getMediaId() 
    {
        return mediaId;
    }
    public void setStudentId(Long studentId) 
    {
        this.studentId = studentId;
    }

    public Long getStudentId() 
    {
        return studentId;
    }
    public void setProgressStatus(Integer progressStatus) 
    {
        this.progressStatus = progressStatus;
    }

    public Integer getProgressStatus() 
    {
        return progressStatus;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("mediaId", getMediaId())
            .append("studentId", getStudentId())
            .append("progressStatus", getProgressStatus())
            .toString();
    }
}
