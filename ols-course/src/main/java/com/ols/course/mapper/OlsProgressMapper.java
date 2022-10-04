package com.ols.course.mapper;

import java.util.List;
import com.ols.course.domain.OlsProgress;

/**
 * 进度Mapper接口
 * 
 * @author 魏渝辉
 * @date 2022-10-04
 */
public interface OlsProgressMapper 
{
    /**
     * 查询进度
     * 
     * @param id 进度主键
     * @return 进度
     */
    public OlsProgress selectOlsProgressById(Long id);

    /**
     * 查询进度列表
     * 
     * @param olsProgress 进度
     * @return 进度集合
     */
    public List<OlsProgress> selectOlsProgressList(OlsProgress olsProgress);

    /**
     * 新增进度
     * 
     * @param olsProgress 进度
     * @return 结果
     */
    public int insertOlsProgress(OlsProgress olsProgress);

    /**
     * 修改进度
     * 
     * @param olsProgress 进度
     * @return 结果
     */
    public int updateOlsProgress(OlsProgress olsProgress);

    /**
     * 删除进度
     * 
     * @param id 进度主键
     * @return 结果
     */
    public int deleteOlsProgressById(Long id);

    /**
     * 批量删除进度
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteOlsProgressByIds(Long[] ids);
}
