package com.wq.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wq.entity.StudentInfo;
import com.wq.entity.SysUser;

import java.util.List;

/**
 * @author 邓卫平
 * @date 2022/01/02 14:38
 */
public interface StudentMapper extends BaseMapper<StudentInfo> {

    List<StudentInfo> findAll(StudentInfo stu);
}
