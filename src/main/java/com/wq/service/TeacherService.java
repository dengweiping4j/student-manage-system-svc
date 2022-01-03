package com.wq.service;

import com.wq.entity.PageParam;
import com.wq.entity.PageResult;
import com.wq.entity.TeacherInfo;

import java.util.List;

/**
 * @author 邓卫平
 * @date 2022/01/02 14:37
 */
public interface TeacherService {
    PageResult<List<TeacherInfo>> findAll(TeacherInfo tea, PageParam pageParam);

    List<TeacherInfo> find(TeacherInfo tea);

    TeacherInfo findById(String id);

    void save(TeacherInfo tea);

    void update(TeacherInfo tea);

    void deleteById(String teaId);
}
