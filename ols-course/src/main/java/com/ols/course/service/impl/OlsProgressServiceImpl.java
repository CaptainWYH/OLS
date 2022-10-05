package com.ols.course.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ols.course.mapper.OlsProgressMapper;
import com.ols.course.domain.OlsProgress;
import com.ols.course.service.IOlsProgressService;

/**
 * 进度Service业务层处理
 * 
 * @author 魏渝辉
 * @date 2022-10-04
 */
@Service
public class OlsProgressServiceImpl implements IOlsProgressService 
{
    @Autowired
    private OlsProgressMapper olsProgressMapper;

    /**
     * 查询进度
     * 
     * @param id 进度主键
     * @return 进度
     */
    @Override
    public OlsProgress selectOlsProgressById(Long id)
    {
        return olsProgressMapper.selectOlsProgressById(id);
    }

    /**
     * 查询进度列表
     * 
     * @param olsProgress 进度
     * @return 进度
     */
    @Override
    public List<OlsProgress> selectOlsProgressList(OlsProgress olsProgress)
    {
        List<OlsProgress> list= olsProgressMapper.selectOlsProgressList(olsProgress);
        return list;
    }

    /**
     * 新增进度
     * 
     * @param olsProgress 进度
     * @return 结果
     */
    @Override
    public int insertOlsProgress(OlsProgress olsProgress)
    {
        return olsProgressMapper.insertOlsProgress(olsProgress);
    }

    /**
     * 修改进度
     * 
     * @param olsProgress 进度
     * @return 结果
     */
    @Override
    public int updateOlsProgress(OlsProgress olsProgress)
    {
        return olsProgressMapper.updateOlsProgress(olsProgress);
    }

    /**
     * 批量删除进度
     * 
     * @param ids 需要删除的进度主键
     * @return 结果
     */
    @Override
    public int deleteOlsProgressByIds(Long[] ids)
    {
        return olsProgressMapper.deleteOlsProgressByIds(ids);
    }

    /**
     * 删除进度信息
     * 
     * @param id 进度主键
     * @return 结果
     */
    @Override
    public int deleteOlsProgressById(Long id)
    {
        return olsProgressMapper.deleteOlsProgressById(id);
    }
}
