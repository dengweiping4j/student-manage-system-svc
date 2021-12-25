package com.wq.service.impl;

import com.wq.entity.SysDictInfo;
import com.wq.entity.SysRole;
import com.wq.service.SysDictInfoService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 邓卫平
 * @date 2021/12/19 14:28
 */
@Service
public class SysDictInfoServiceImpl implements SysDictInfoService {
    @Override
    public List<SysDictInfo> find(SysDictInfo dictInfo) {
        return null;
    }

    @Override
    public SysRole findById(String id) {
        return null;
    }

    @Override
    public void save(SysDictInfo dictInfo) {

    }

    @Override
    public void update(SysDictInfo dictInfo) {

    }

    @Override
    public void deleteById(String id) {

    }
}
