package com.wq.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.wq.entity.GradeInfo;
import com.wq.entity.PageParam;
import com.wq.entity.PageResult;
import com.wq.mapper.GradeInfoMapper;
import com.wq.service.GradeInfoService;
import com.wq.service.GradeInfoService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 邓卫平
 * @date 2022/01/02 14:38
 */
@Service
public class GradeInfoServiceImpl implements GradeInfoService {
    @Autowired
    private GradeInfoMapper gradeInfoMapper;

    @Override
    public PageResult<List<GradeInfo>> findAll(GradeInfo gradeInfo, PageParam pageParam) {
        QueryWrapper<GradeInfo> query = new QueryWrapper<>();
        if (StringUtils.isNotBlank(gradeInfo.getGradeName())) {
            query.like("grade_name", gradeInfo.getGradeName());
        }
        Page<GradeInfo> page = PageHelper.startPage(pageParam);
        List<GradeInfo> list = gradeInfoMapper.selectList(query);
        PageResult result = new PageResult();
        result.setTotalElements(page.getTotal());
        result.setContent(list);
        return result;
    }

    @Override
    public List<GradeInfo> find(GradeInfo gradeInfo) {
        QueryWrapper<GradeInfo> query = new QueryWrapper<>();
        if (StringUtils.isNotBlank(gradeInfo.getGradeName())) {
            query.like("grade_name", gradeInfo.getGradeName());
        }
        return gradeInfoMapper.selectList(query);
    }

    @Override
    public GradeInfo findById(String id) {
        return gradeInfoMapper.selectById(id);
    }

    @Override
    public void save(GradeInfo gradeInfo) {
        gradeInfoMapper.insert(gradeInfo);
    }

    @Override
    public void update(GradeInfo gradeInfo) {
        gradeInfoMapper.updateById(gradeInfo);
    }

    @Override
    public void deleteById(String stuId) {
        gradeInfoMapper.deleteById(stuId);
    }
}
