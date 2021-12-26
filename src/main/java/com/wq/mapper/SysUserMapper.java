package com.wq.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wq.entity.SysUser;

import java.util.List;

/**
 * @author 邓卫平
 * @date 2021/12/19 17:47
 */
public interface SysUserMapper extends BaseMapper<SysUser> {

    List<SysUser> findAll(SysUser param);

    SysUser login(SysUser user);

    int insertSelective(SysUser user);

    int updateByIdSelective(SysUser user);
}
