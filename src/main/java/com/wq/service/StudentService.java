package com.wq.service;

import com.wq.entity.PageParam;
import com.wq.entity.PageResult;
import com.wq.entity.StudentInfo;

import java.util.List;

/**
 * @author 邓卫平
 * @date 2022/01/02 14:37
 */
public interface StudentService {
    PageResult<List<StudentInfo>> findAll(StudentInfo stu, PageParam pageParam);

    List<StudentInfo> find(StudentInfo stu);

    StudentInfo findById(String id);

    void save(StudentInfo stu);

    void update(StudentInfo stu);

    void deleteById(String stuId);
}
