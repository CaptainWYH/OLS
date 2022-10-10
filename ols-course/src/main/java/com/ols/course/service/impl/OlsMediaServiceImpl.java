package com.ols.course.service.impl;

import java.util.List;
import com.ols.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ols.course.mapper.OlsMediaMapper;
import com.ols.course.domain.OlsMedia;
import com.ols.course.service.IOlsMediaService;

/**
 * 学习媒体Service业务层处理
 *
 * @author 魏渝辉
 * @date 2022-10-04
 */
@Service
public class OlsMediaServiceImpl implements IOlsMediaService
{
    @Autowired
    private OlsMediaMapper olsMediaMapper;

    /**
     * 查询学习媒体
     *
     * @param id 学习媒体主键
     * @return 学习媒体
     */
    @Override
    public OlsMedia selectOlsMediaById(Long id)
    {
        return olsMediaMapper.selectOlsMediaById(id);
    }

    /**
     * 查询学习媒体列表
     *
     * @param olsMedia 学习媒体
     * @return 学习媒体
     */
    @Override
    public List<OlsMedia> selectOlsMediaList(OlsMedia olsMedia)
    {
        return olsMediaMapper.selectOlsMediaList(olsMedia);
    }

    /**
     * 新增学习媒体
     *
     * @param olsMedia 学习媒体
     * @return 结果
     */
    @Override
    public int insertOlsMedia(OlsMedia olsMedia)
    {
        olsMedia.setCreateTime(DateUtils.getNowDate());
        return olsMediaMapper.insertOlsMedia(olsMedia);
    }

    /**
     * 修改学习媒体
     *
     * @param olsMedia 学习媒体
     * @return 结果
     */
    @Override
    public int updateOlsMedia(OlsMedia olsMedia)
    {
        olsMedia.setUpdateTime(DateUtils.getNowDate());
        return olsMediaMapper.updateOlsMedia(olsMedia);
    }

    /**
     * 批量删除学习媒体
     *
     * @param ids 需要删除的学习媒体主键
     * @return 结果
     */
    @Override
    public int deleteOlsMediaByIds(Long[] ids)
    {
        return olsMediaMapper.deleteOlsMediaByIds(ids);
    }

    /**
     * 删除学习媒体信息
     *
     * @param id 学习媒体主键
     * @return 结果
     */
    @Override
    public int deleteOlsMediaById(Long id)
    {
        return olsMediaMapper.deleteOlsMediaById(id);
    }

    /**
     * 根据sectionId获取视频
     * @param sectionId
     * @return
     */
    @Override
    public OlsMedia getMedia(Long sectionId) {
        return olsMediaMapper.getMedia(sectionId);
    }
}
