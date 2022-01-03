package com.wq.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.wq.entity.PageParam;
import com.wq.entity.PageResult;
import com.wq.entity.ClassInfo;
import com.wq.mapper.ClassInfoMapper;
import com.wq.service.ClassInfoService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 邓卫平
 * @date 2022/01/02 14:38
 */
@Service
public class ClassInfoServiceImpl implements ClassInfoService {
    @Autowired
    private ClassInfoMapper classInfoMapper;

    @Override
    public PageResult<List<ClassInfo>> findAll(ClassInfo stu, PageParam pageParam) {
        QueryWrapper<ClassInfo> query = new QueryWrapper<>();
        if (StringUtils.isNotBlank(stu.getClaName())) {
            query.like("cla_name", stu.getClaName());
        }
        if (stu != null && StringUtils.isNotBlank(stu.getGradeId())) {
            query.eq("grade_id", stu.getGradeId());
        }
        Page<ClassInfo> page = PageHelper.startPage(pageParam);
        List<ClassInfo> list = classInfoMapper.selectList(query);
        PageResult result = new PageResult();
        result.setTotalElements(page.getTotal());
        result.setContent(list);
        return result;
    }

    @Override
    public List<ClassInfo> find(ClassInfo stu) {
        QueryWrapper<ClassInfo> query = new QueryWrapper<>();
        if (StringUtils.isNotBlank(stu.getClaName())) {
            query.like("cla_name", stu.getClaName());
        }
        return classInfoMapper.selectList(query);
    }

    @Override
    public ClassInfo findById(String id) {
        return classInfoMapper.selectById(id);
    }

    @Override
    public void save(ClassInfo stu) {
        classInfoMapper.insert(stu);
    }

    @Override
    public void update(ClassInfo stu) {
        classInfoMapper.updateById(stu);
    }

    @Override
    public void deleteById(String stuId) {
        classInfoMapper.deleteById(stuId);
    }
}
