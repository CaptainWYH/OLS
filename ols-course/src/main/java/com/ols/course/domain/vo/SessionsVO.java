package com.ols.course.domain.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SessionsVO {

    /**
     * 主键
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    /**
     * pid
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long pId;

    /**
     * 章节名称
     */
    private String sectionName;

    /**
     * 子章节
     */
    private List<SessionsVO> child;
}
