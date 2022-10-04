package com.ols.course.controller;

import java.util.Arrays;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.baomidou.mybatisplus.core.toolkit.IdWorker;
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
import com.ols.course.domain.OlsCourse;
import com.ols.course.service.IOlsCourseService;
import com.ols.common.utils.poi.ExcelUtil;
import com.ols.common.core.page.TableDataInfo;

/**
 * 课程Controller
 *
 * @author 魏渝辉
 * @date 2022-10-04
 */
@RestController
@RequestMapping("/ols-course/course")
public class OlsCourseController extends BaseController
{
    @Autowired
    private IOlsCourseService olsCourseService;

    /**
     * 查询课程列表
     */
    @PreAuthorize("@ss.hasPermi('ols-course:course:list')")
    @GetMapping("/list")
    public TableDataInfo list(OlsCourse olsCourse)
    {
        startPage();
        List<OlsCourse> list = olsCourseService.selectOlsCourseList(olsCourse);
        return getDataTable(list);
    }

    /**
     * 导出课程列表
     */
    @PreAuthorize("@ss.hasPermi('ols-course:course:export')")
    @Log(title = "课程", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, OlsCourse olsCourse)
    {
        List<OlsCourse> list = olsCourseService.selectOlsCourseList(olsCourse);
        ExcelUtil<OlsCourse> util = new ExcelUtil<OlsCourse>(OlsCourse.class);
        util.exportExcel(response, list, "课程数据");
    }

    /**
     * 获取课程详细信息
     */
    @PreAuthorize("@ss.hasPermi('ols-course:course:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(olsCourseService.selectOlsCourseById(id));
    }

    /**
     * 新增课程
     */
    @PreAuthorize("@ss.hasPermi('ols-course:course:add')")
    @Log(title = "课程", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody OlsCourse olsCourse)
    {
        olsCourse.setCreateBy(getUsername());
        olsCourse.setId(IdWorker.getId());
        return toAjax(olsCourseService.insertOlsCourse(olsCourse));
    }

    /**
     * 修改课程
     */
    @PreAuthorize("@ss.hasPermi('ols-course:course:edit')")
    @Log(title = "课程", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody OlsCourse olsCourse)
    {
        olsCourse.setUpdateBy(getUsername());
        return toAjax(olsCourseService.updateOlsCourse(olsCourse));
    }

    /**
     * 删除课程
     */
    @PreAuthorize("@ss.hasPermi('ols-course:course:remove')")
    @Log(title = "课程", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(olsCourseService.removeBatchByIds(Arrays.asList(ids)));
    }
}
