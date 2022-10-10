package com.ols.course.mapper;

import java.util.List;
import com.ols.course.domain.OlsMedia;

/**
 * 学习媒体Mapper接口
 *
 * @author 魏渝辉
 * @date 2022-10-04
 */
public interface OlsMediaMapper
{
    /**
     * 查询学习媒体
     *
     * @param id 学习媒体主键
     * @return 学习媒体
     */
    public OlsMedia selectOlsMediaById(Long id);

    /**
     * 查询学习媒体列表
     *
     * @param olsMedia 学习媒体
     * @return 学习媒体集合
     */
    public List<OlsMedia> selectOlsMediaList(OlsMedia olsMedia);

    /**
     * 新增学习媒体
     *
     * @param olsMedia 学习媒体
     * @return 结果
     */
    public int insertOlsMedia(OlsMedia olsMedia);

    /**
     * 修改学习媒体
     *
     * @param olsMedia 学习媒体
     * @return 结果
     */
    public int updateOlsMedia(OlsMedia olsMedia);

    /**
     * 删除学习媒体
     *
     * @param id 学习媒体主键
     * @return 结果
     */
    public int deleteOlsMediaById(Long id);

    /**
     * 批量删除学习媒体
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteOlsMediaByIds(Long[] ids);

    /**
     * 根据sectionId获取视频
     * @param sectionId
     * @return
     */
    OlsMedia getMedia(Long sectionId);
}
