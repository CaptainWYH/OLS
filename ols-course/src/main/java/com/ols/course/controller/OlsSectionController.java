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
import com.ols.course.domain.OlsSection;
import com.ols.course.service.IOlsSectionService;
import com.ols.common.utils.poi.ExcelUtil;
import com.ols.common.core.page.TableDataInfo;

/**
 * 章节Controller
 * 
 * @author 魏渝辉
 * @date 2022-10-04
 */
@RestController
@RequestMapping("/ols-course/section")
public class OlsSectionController extends BaseController
{
    @Autowired
    private IOlsSectionService olsSectionService;

    /**
     * 查询章节列表
     */
    @PreAuthorize("@ss.hasPermi('ols-course:section:list')")
    @GetMapping("/list")
    public TableDataInfo list(OlsSection olsSection)
    {
        startPage();
        List<OlsSection> list = olsSectionService.selectOlsSectionList(olsSection);
        return getDataTable(list);
    }

    /**
     * 导出章节列表
     */
    @PreAuthorize("@ss.hasPermi('ols-course:section:export')")
    @Log(title = "章节", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, OlsSection olsSection)
    {
        List<OlsSection> list = olsSectionService.selectOlsSectionList(olsSection);
        ExcelUtil<OlsSection> util = new ExcelUtil<OlsSection>(OlsSection.class);
        util.exportExcel(response, list, "章节数据");
    }

    /**
     * 获取章节详细信息
     */
    @PreAuthorize("@ss.hasPermi('ols-course:section:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(olsSectionService.selectOlsSectionById(id));
    }

    /**
     * 新增章节
     */
    @PreAuthorize("@ss.hasPermi('ols-course:section:add')")
    @Log(title = "章节", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody OlsSection olsSection)
    {
        return toAjax(olsSectionService.insertOlsSection(olsSection));
    }

    /**
     * 修改章节
     */
    @PreAuthorize("@ss.hasPermi('ols-course:section:edit')")
    @Log(title = "章节", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody OlsSection olsSection)
    {
        return toAjax(olsSectionService.updateOlsSection(olsSection));
    }

    /**
     * 删除章节
     */
    @PreAuthorize("@ss.hasPermi('ols-course:section:remove')")
    @Log(title = "章节", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(olsSectionService.deleteOlsSectionByIds(ids));
    }
}
