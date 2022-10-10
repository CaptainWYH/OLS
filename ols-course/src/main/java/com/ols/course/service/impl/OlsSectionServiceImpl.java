package com.ols.course.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ols.common.utils.DateUtils;
import com.ols.common.utils.bean.BeanUtils;
import com.ols.course.domain.vo.SessionsVO;
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
public class OlsSectionServiceImpl extends ServiceImpl<OlsSectionMapper,OlsSection> implements IOlsSectionService
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

    /**
     * 获取课程下的章节信息
     */
    @Override
    public List<SessionsVO> getSessionsByCourseId(Long id) {
        List<SessionsVO> sectionVoList = olsSectionMapper.getSectionVoList(id);
        //父节点
        List<SessionsVO> parents = sectionVoList.stream().filter(e -> e.getPId() == null).collect(Collectors.toList());
        for (SessionsVO parent : parents) {
            if(null == parent.getChild()){
                parent.setChild(new ArrayList<SessionsVO>());
            }
            List<SessionsVO> children = parent.getChild();
            for (SessionsVO child : sectionVoList) {
                if(parent.getId().equals(child.getPId())){
                    children.add(child);
                }
            }
        }
        return parents;
    }
}
