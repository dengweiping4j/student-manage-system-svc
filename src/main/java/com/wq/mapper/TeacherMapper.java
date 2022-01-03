package com.wq.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wq.entity.StudentInfo;
import com.wq.entity.SysUser;
import com.wq.entity.TeacherInfo;

import java.util.List;

/**
 * @author 邓卫平
 * @date 2022/01/02 14:38
 */
public interface TeacherMapper extends BaseMapper<TeacherInfo> {

    List<TeacherInfo> findAll(TeacherInfo tea);
}
