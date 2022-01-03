package com.wq.service;

import com.wq.entity.GradeInfo;
import com.wq.entity.PageParam;
import com.wq.entity.PageResult;

import java.util.List;

/**
 * @author 邓卫平
 * @date 2022/01/02 14:37
 */
public interface GradeInfoService {
    PageResult<List<GradeInfo>> findAll(GradeInfo gradeInfo, PageParam pageParam);

    List<GradeInfo> find(GradeInfo gradeInfo);

    GradeInfo findById(String id);

    void save(GradeInfo gradeInfo);

    void update(GradeInfo gradeInfo);

    void deleteById(String gradeId);
}
