package com.ols.course.domain;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
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
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OlsProgress extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    /** 媒体id */
    @Excel(name = "媒体id")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long mediaId;

    /** 学生id */
    @Excel(name = "学生id")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long studentId;

    /** 进度状态：0.0% 1.33.3% 2.66.6% 3.100% */
    @Excel(name = "进度状态：0.0% 1.33.3% 2.66.6% 3.100%")
    private Integer progressStatus;
    /**
     * 当前播放时间
     */
    private double curTime;

}
