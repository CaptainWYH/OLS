package com.ols.course.mapper;

import java.util.List;
import com.ols.course.domain.OlsSection;

/**
 * 章节Mapper接口
 * 
 * @author 魏渝辉
 * @date 2022-10-04
 */
public interface OlsSectionMapper 
{
    /**
     * 查询章节
     * 
     * @param id 章节主键
     * @return 章节
     */
    public OlsSection selectOlsSectionById(Long id);

    /**
     * 查询章节列表
     * 
     * @param olsSection 章节
     * @return 章节集合
     */
    public List<OlsSection> selectOlsSectionList(OlsSection olsSection);

    /**
     * 新增章节
     * 
     * @param olsSection 章节
     * @return 结果
     */
    public int insertOlsSection(OlsSection olsSection);

    /**
     * 修改章节
     * 
     * @param olsSection 章节
     * @return 结果
     */
    public int updateOlsSection(OlsSection olsSection);

    /**
     * 删除章节
     * 
     * @param id 章节主键
     * @return 结果
     */
    public int deleteOlsSectionById(Long id);

    /**
     * 批量删除章节
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteOlsSectionByIds(Long[] ids);
}