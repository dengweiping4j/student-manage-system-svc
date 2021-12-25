package com.wq.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.wq.entity.*;
import com.wq.mapper.SysDictMapper;
import com.wq.service.SysDictItemService;
import com.wq.service.SysDictService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.security.auth.callback.Callback;
import java.util.List;

/**
 * @author 邓卫平
 * @date 2021/12/19 14:28
 */
@Service
public class SysDictServiceImpl implements SysDictService {
    @Autowired
    private SysDictMapper dictMapper;

    @Autowired
    private SysDictItemService dictItemService;

    @Override
    public PageResult<List<SysDict>> findAll(SysDict dict, PageParam pageParam) {
        QueryWrapper<SysDict> query = new QueryWrapper<>();
        if (dict != null) {
            if (StringUtils.isNotBlank(dict.getTypeName())) {
                query.like("type_name", dict.getTypeName());
            }
            if (StringUtils.isNotBlank(dict.getLookupType())) {
                query.like("lookup_type", dict.getLookupType());
            }
        }

        Page<SysDict> page = PageHelper.startPage(pageParam);
        List<SysDict> list = dictMapper.selectList(query);

        PageResult result = new PageResult();
        result.setTotalElements(page.getTotal());
        result.setContent(list);
        return result;
    }

    @Override
    public List<SysDict> find(SysDict dict) {
        QueryWrapper<SysDict> query = new QueryWrapper<>();
        if (dict != null) {
            if (StringUtils.isNotBlank(dict.getTypeName())) {
                query.like("type_name", dict.getTypeName());
            }
            if (StringUtils.isNotBlank(dict.getLookupType())) {
                query.like("lookup_type", dict.getLookupType());
            }
        }
        List<SysDict> list = dictMapper.selectList(query);
        return list;
    }

    @Override
    public SysDict findById(String id) {
        SysDict dict = dictMapper.selectById(id);
        return dict;
    }

    @Override
    public void save(SysDict dict) {
        dictMapper.insert(dict);
    }

    @Override
    public void update(SysDict dict) {
        dictMapper.updateById(dict);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteById(String id) {
        SysDict result = this.findById(id);
        if (result == null) {
            throw new RuntimeException("未找到字典信息");
        }
        dictMapper.deleteById(id);
        dictItemService.deleteByLookupType(result.getLookupType());
    }
}
