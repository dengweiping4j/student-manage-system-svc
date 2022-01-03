package com.wq.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.wq.entity.*;
import com.wq.mapper.StudentMapper;
import com.wq.service.StudentService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 邓卫平
 * @date 2022/01/02 14:38
 */
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public PageResult<List<StudentInfo>> findAll(StudentInfo stu, PageParam pageParam) {
        Page<StudentInfo> page = PageHelper.startPage(pageParam);
        List<StudentInfo> list = studentMapper.findAll(stu);
        PageResult result = new PageResult();
        result.setTotalElements(page.getTotal());
        result.setContent(list);
        return result;
    }

    @Override
    public List<StudentInfo> find(StudentInfo stu) {
        QueryWrapper<StudentInfo> query = new QueryWrapper<>();
        if (StringUtils.isNotBlank(stu.getStuName())) {
            query.like("stu_name", stu.getStuName());
        }
        return studentMapper.selectList(query);
    }

    @Override
    public StudentInfo findById(String id) {
        return studentMapper.selectById(id);
    }

    @Override
    public void save(StudentInfo stu) {
        studentMapper.insert(stu);
    }

    @Override
    public void update(StudentInfo stu) {
        studentMapper.updateById(stu);
    }

    @Override
    public void deleteById(String stuId) {
        studentMapper.deleteById(stuId);
    }
}
