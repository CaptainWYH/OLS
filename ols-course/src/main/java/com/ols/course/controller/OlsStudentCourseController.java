package com.ols.course.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ols.course.domain.vo.StudentCourseListVO;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ols.common.annotation.Log;
import com.ols.common.core.controller.BaseController;
import com.ols.common.core.domain.AjaxResult;
import com.ols.common.enums.BusinessType;
import com.ols.course.domain.OlsStudentCourse;
import com.ols.course.service.IOlsStudentCourseService;
import com.ols.common.utils.poi.ExcelUtil;
import com.ols.common.core.page.TableDataInfo;

/**
 * 选课Controller
 *
 * @author 魏渝辉
 * @date 2022-10-04
 */
@RestController
@RequestMapping("/ols-course/selection")
public class OlsStudentCourseController extends BaseController
{
    @Autowired
    private IOlsStudentCourseService olsStudentCourseService;

    /**
     * 查询选课列表
     */
    @PreAuthorize("@ss.hasPermi('ols-course:course:list')")
    @GetMapping("/list")
    public TableDataInfo list(OlsStudentCourse olsStudentCourse)
    {
        startPage();
        List<StudentCourseListVO> list = olsStudentCourseService.selectOlsStudentCourseListVO(olsStudentCourse);
        return getDataTable(list);
    }

    /**
     * 导出选课列表
     */
    @PreAuthorize("@ss.hasPermi('ols-course:course:export')")
    @Log(title = "选课", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, OlsStudentCourse olsStudentCourse)
    {
        List<OlsStudentCourse> list = olsStudentCourseService.selectOlsStudentCourseList(olsStudentCourse);
        ExcelUtil<OlsStudentCourse> util = new ExcelUtil<OlsStudentCourse>(OlsStudentCourse.class);
        util.exportExcel(response, list, "选课数据");
    }

    /**
     * 获取选课详细信息
     */
    @PreAuthorize("@ss.hasPermi('ols-course:course:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(olsStudentCourseService.selectOlsStudentCourseById(id));
    }

    /**
     * 新增选课
     */
    @PreAuthorize("@ss.hasPermi('ols-course:course:add')")
    @Log(title = "选课", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody OlsStudentCourse olsStudentCourse)
    {
        return toAjax(olsStudentCourseService.insertOlsStudentCourse(olsStudentCourse));
    }

    /**
     * 修改选课
     */
    @PreAuthorize("@ss.hasPermi('ols-course:course:edit')")
    @Log(title = "选课", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody OlsStudentCourse olsStudentCourse)
    {
        return toAjax(olsStudentCourseService.updateOlsStudentCourse(olsStudentCourse));
    }

    /**
     * 删除选课
     */
    @PreAuthorize("@ss.hasPermi('ols-course:course:remove')")
    @Log(title = "选课", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(olsStudentCourseService.deleteOlsStudentCourseByIds(ids));
    }
}
