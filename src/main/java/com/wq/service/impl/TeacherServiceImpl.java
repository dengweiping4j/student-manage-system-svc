package com.wq.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.wq.entity.PageParam;
import com.wq.entity.PageResult;
import com.wq.entity.TeacherInfo;
import com.wq.entity.SysUser;
import com.wq.mapper.StudentMapper;
import com.wq.mapper.TeacherMapper;
import com.wq.service.StudentService;
import com.wq.service.TeacherService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 邓卫平
 * @date 2022/01/02 14:38
 */
@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private TeacherMapper teacherMapper;

    @Override
    public PageResult<List<TeacherInfo>> findAll(TeacherInfo tea, PageParam pageParam) {
        Page<TeacherInfo> page = PageHelper.startPage(pageParam);
        List<TeacherInfo> list = teacherMapper.findAll(tea);
        PageResult result = new PageResult();
        result.setTotalElements(page.getTotal());
        result.setContent(list);
        return result;
    }

    @Override
    public List<TeacherInfo> find(TeacherInfo tea) {
        QueryWrapper<TeacherInfo> query = new QueryWrapper<>();
        if (StringUtils.isNotBlank(tea.getTeaName())) {
            query.like("tea_name", tea.getTeaName());
        }
        if (StringUtils.isNotBlank(tea.getSubject())) {
            query.eq("subject", tea.getSubject());
        }
        return teacherMapper.selectList(query);
    }

    @Override
    public TeacherInfo findById(String id) {
        return teacherMapper.selectById(id);
    }

    @Override
    public void save(TeacherInfo tea) {
        teacherMapper.insert(tea);
    }

    @Override
    public void update(TeacherInfo tea) {
        teacherMapper.updateById(tea);
    }

    @Override
    public void deleteById(String stuId) {
        teacherMapper.deleteById(stuId);
    }
}
