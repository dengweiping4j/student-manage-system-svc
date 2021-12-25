package com.wq.service;

import com.wq.entity.SysDictItem;

import java.util.List;

/**
 * @author 邓卫平
 * @date 2021/12/18 21:33
 */
public interface SysDictItemService {

    List<SysDictItem> find(SysDictItem dictItem);

    void save(SysDictItem dictItem);

    void update(SysDictItem dictItem);

    void deleteById(String id);

    void deleteByLookupType(String lookupType);
}
