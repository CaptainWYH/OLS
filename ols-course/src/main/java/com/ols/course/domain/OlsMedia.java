package com.ols.course.domain;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ols.common.annotation.Excel;
import com.ols.common.core.domain.BaseEntity;

/**
 * 学习媒体对象 ols_media
 *
 * @author 魏渝辉
 * @date 2022-10-04
 */
public class OlsMedia extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    /** 章节id */
    @Excel(name = "章节id")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long sectionId;

    /** 媒体内容 */
    @Excel(name = "媒体内容")
    private String mediaContent;

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
    public void setSectionId(Long sectionId)
    {
        this.sectionId = sectionId;
    }

    public Long getSectionId()
    {
        return sectionId;
    }
    public void setMediaContent(String mediaContent)
    {
        this.mediaContent = mediaContent;
    }

    public String getMediaContent()
    {
        return mediaContent;
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
            .append("sectionId", getSectionId())
            .append("mediaContent", getMediaContent())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("version", getVersion())
            .toString();
    }
}
