package com.ols.course.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
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
import com.ols.course.domain.OlsProgress;
import com.ols.course.service.IOlsProgressService;
import com.ols.common.utils.poi.ExcelUtil;
import com.ols.common.core.page.TableDataInfo;

/**
 * 进度Controller
 * 
 * @author 魏渝辉
 * @date 2022-10-04
 */
@RestController
@RequestMapping("/ols-course/progress")
public class OlsProgressController extends BaseController
{
    @Autowired
    private IOlsProgressService olsProgressService;

    /**
     * 查询进度列表
     */
    @PreAuthorize("@ss.hasPermi('ols-course:progress:list')")
    @GetMapping("/list")
    public TableDataInfo list(OlsProgress olsProgress)
    {
        startPage();
        List<OlsProgress> list = olsProgressService.selectOlsProgressList(olsProgress);
        return getDataTable(list);
    }

    /**
     * 导出进度列表
     */
    @PreAuthorize("@ss.hasPermi('ols-course:progress:export')")
    @Log(title = "进度", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, OlsProgress olsProgress)
    {
        List<OlsProgress> list = olsProgressService.selectOlsProgressList(olsProgress);
        ExcelUtil<OlsProgress> util = new ExcelUtil<OlsProgress>(OlsProgress.class);
        util.exportExcel(response, list, "进度数据");
    }

    /**
     * 获取进度详细信息
     */
    @PreAuthorize("@ss.hasPermi('ols-course:progress:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(olsProgressService.selectOlsProgressById(id));
    }

    /**
     * 新增进度
     */
    @PreAuthorize("@ss.hasPermi('ols-course:progress:add')")
    @Log(title = "进度", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody OlsProgress olsProgress)
    {
        return toAjax(olsProgressService.insertOlsProgress(olsProgress));
    }

    /**
     * 修改进度
     */
    @PreAuthorize("@ss.hasPermi('ols-course:progress:edit')")
    @Log(title = "进度", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody OlsProgress olsProgress)
    {
        return toAjax(olsProgressService.updateOlsProgress(olsProgress));
    }

    /**
     * 删除进度
     */
    @PreAuthorize("@ss.hasPermi('ols-course:progress:remove')")
    @Log(title = "进度", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(olsProgressService.deleteOlsProgressByIds(ids));
    }
}
