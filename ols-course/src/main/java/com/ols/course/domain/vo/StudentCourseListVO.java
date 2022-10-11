package com.ols.course.domain.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.ols.common.annotation.Excel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class StudentCourseListVO {

    /** 主键 */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    /** 学生id */
    @Excel(name = "学生id")
    private Long studnetId;

    /**
     *  学生姓名
     */
    @Excel(name = "学生姓名")
    private String nickName;

    /** 课程id */
    @Excel(name = "课程id")
    private Long courseId;

    /**
     * 课程名称
     */
    @Excel(name = "课程名称")
    private String courseName;

    /** 取得学分 */
    @Excel(name = "取得学分")
    private BigDecimal courseCredit;
}
