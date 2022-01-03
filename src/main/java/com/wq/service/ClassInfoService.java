package com.wq.service;

import com.wq.entity.PageParam;
import com.wq.entity.PageResult;
import com.wq.entity.ClassInfo;

import java.util.List;

/**
 * @author 邓卫平
 * @date 2022/01/02 14:37
 */
public interface ClassInfoService {
    PageResult<List<ClassInfo>> findAll(ClassInfo cla, PageParam pageParam);

    List<ClassInfo> find(ClassInfo cla);

    ClassInfo findById(String id);

    void save(ClassInfo cla);

    void update(ClassInfo cla);

    void deleteById(String claId);
}
