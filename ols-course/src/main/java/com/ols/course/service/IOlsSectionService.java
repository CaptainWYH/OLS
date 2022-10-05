package com.ols.course.service;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ols.course.domain.OlsSection;
import com.ols.course.domain.vo.SessionsVO;

/**
 * 章节Service接口
 *
 * @author 魏渝辉
 * @date 2022-10-04
 */
public interface IOlsSectionService extends IService<OlsSection>
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
     * 批量删除章节
     *
     * @param ids 需要删除的章节主键集合
     * @return 结果
     */
    public int deleteOlsSectionByIds(Long[] ids);

    /**
     * 删除章节信息
     *
     * @param id 章节主键
     * @return 结果
     */
    public int deleteOlsSectionById(Long id);

    /**
     * 获取课程下的章节信息
     */

    public List<SessionsVO> getSessionsByCourseId(Long id);
}
