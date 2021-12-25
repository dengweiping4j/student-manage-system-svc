package com.wq.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.wq.entity.PageParam;
import com.wq.entity.PageResult;
import com.wq.entity.SysDict;
import com.wq.entity.SysDictItem;
import com.wq.mapper.SysDictItemMapper;
import com.wq.mapper.SysDictMapper;
import com.wq.service.SysDictItemService;
import com.wq.service.SysDictService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 邓卫平
 * @date 2021/12/19 14:28
 */
@Service
public class SysDictItemServiceImpl implements SysDictItemService {
    @Autowired
    private SysDictItemMapper dictItemMapper;

    @Override
    public List<SysDictItem> find(SysDictItem dictItem) {
        QueryWrapper<SysDictItem> query = new QueryWrapper<>();
        if (dictItem != null) {
            if (StringUtils.isNotBlank(dictItem.getLookupType())) {
                query.like("lookup_type", dictItem.getLookupType());
            }
        }
        List<SysDictItem> list = dictItemMapper.selectList(query);
        return list;
    }

    @Override
    public void save(SysDictItem dictItem) {
        dictItemMapper.insert(dictItem);
    }

    @Override
    public void update(SysDictItem dictItem) {
        dictItemMapper.updateById(dictItem);
    }

    @Override
    public void deleteById(String id) {
        dictItemMapper.deleteById(id);
    }

    @Override
    public void deleteByLookupType(String lookupType) {
        dictItemMapper.delete(new QueryWrapper<SysDictItem>()
                .eq("lookup_type", lookupType));
    }

}
