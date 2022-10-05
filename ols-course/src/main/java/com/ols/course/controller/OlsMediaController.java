package com.ols.course.controller;

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
import com.ols.course.domain.OlsMedia;
import com.ols.course.service.IOlsMediaService;
import com.ols.common.utils.poi.ExcelUtil;
import com.ols.common.core.page.TableDataInfo;

/**
 * 学习媒体Controller
 *
 * @author 魏渝辉
 * @date 2022-10-04
 */
@RestController
@RequestMapping("/ols-course/media")
public class OlsMediaController extends BaseController
{
    @Autowired
    private IOlsMediaService olsMediaService;

    /**
     * 查询学习媒体列表
     */
    @PreAuthorize("@ss.hasPermi('ols-course:media:list')")
    @GetMapping("/list")
    public TableDataInfo list(OlsMedia olsMedia)
    {
        startPage();
        List<OlsMedia> list = olsMediaService.selectOlsMediaList(olsMedia);
        return getDataTable(list);
    }

    /**
     * 导出学习媒体列表
     */
    @PreAuthorize("@ss.hasPermi('ols-course:media:export')")
    @Log(title = "学习媒体", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, OlsMedia olsMedia)
    {
        List<OlsMedia> list = olsMediaService.selectOlsMediaList(olsMedia);
        ExcelUtil<OlsMedia> util = new ExcelUtil<OlsMedia>(OlsMedia.class);
        util.exportExcel(response, list, "学习媒体数据");
    }

    /**
     * 获取学习媒体详细信息
     */
    @PreAuthorize("@ss.hasPermi('ols-course:media:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(olsMediaService.selectOlsMediaById(id));
    }

    /**
     * 新增学习媒体
     */
    @PreAuthorize("@ss.hasPermi('ols-course:media:add')")
    @Log(title = "学习媒体", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody OlsMedia olsMedia)
    {
        olsMedia.setCreateBy(getUsername());
        olsMedia.setId(IdWorker.getId());
        return toAjax(olsMediaService.insertOlsMedia(olsMedia));
    }

    /**
     * 修改学习媒体
     */
    @PreAuthorize("@ss.hasPermi('ols-course:media:edit')")
    @Log(title = "学习媒体", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody OlsMedia olsMedia)
    {
        return toAjax(olsMediaService.updateOlsMedia(olsMedia));
    }

    /**
     * 删除学习媒体
     */
    @PreAuthorize("@ss.hasPermi('ols-course:media:remove')")
    @Log(title = "学习媒体", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(olsMediaService.deleteOlsMediaByIds(ids));
    }
}
