package com.ols.course.service.impl;

import java.util.List;
import com.ols.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ols.course.mapper.OlsSectionMapper;
import com.ols.course.domain.OlsSection;
import com.ols.course.service.IOlsSectionService;

/**
 * 章节Service业务层处理
 * 
 * @author 魏渝辉
 * @date 2022-10-04
 */
@Service
public class OlsSectionServiceImpl implements IOlsSectionService 
{
    @Autowired
    private OlsSectionMapper olsSectionMapper;

    /**
     * 查询章节
     * 
     * @param id 章节主键
     * @return 章节
     */
    @Override
    public OlsSection selectOlsSectionById(Long id)
    {
        return olsSectionMapper.selectOlsSectionById(id);
    }

    /**
     * 查询章节列表
     * 
     * @param olsSection 章节
     * @return 章节
     */
    @Override
    public List<OlsSection> selectOlsSectionList(OlsSection olsSection)
    {
        return olsSectionMapper.selectOlsSectionList(olsSection);
    }

    /**
     * 新增章节
     * 
     * @param olsSection 章节
     * @return 结果
     */
    @Override
    public int insertOlsSection(OlsSection olsSection)
    {
        olsSection.setCreateTime(DateUtils.getNowDate());
        return olsSectionMapper.insertOlsSection(olsSection);
    }

    /**
     * 修改章节
     * 
     * @param olsSection 章节
     * @return 结果
     */
    @Override
    public int updateOlsSection(OlsSection olsSection)
    {
        olsSection.setUpdateTime(DateUtils.getNowDate());
        return olsSectionMapper.updateOlsSection(olsSection);
    }

    /**
     * 批量删除章节
     * 
     * @param ids 需要删除的章节主键
     * @return 结果
     */
    @Override
    public int deleteOlsSectionByIds(Long[] ids)
    {
        return olsSectionMapper.deleteOlsSectionByIds(ids);
    }

    /**
     * 删除章节信息
     * 
     * @param id 章节主键
     * @return 结果
     */
    @Override
    public int deleteOlsSectionById(Long id)
    {
        return olsSectionMapper.deleteOlsSectionById(id);
    }
}
