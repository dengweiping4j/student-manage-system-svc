package com.wq.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.wq.entity.Contants;
import com.wq.entity.PageParam;
import com.wq.entity.PageResult;
import com.wq.entity.SysUser;
import com.wq.mapper.SysUserMapper;
import com.wq.service.SysUserService;
import com.wq.util.JwtUtil;
import com.wq.util.Md5Utils;
import com.wq.util.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 邓卫平
 * @date 2021/12/18 21:33
 */
@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public PageResult<List<SysUser>> findAll(SysUser user, PageParam pageParam) {
        Page<SysUser> page = PageHelper.startPage(pageParam);
        List<SysUser> list = sysUserMapper.findAll(user);
        PageResult result = new PageResult();
        result.setTotalElements(page.getTotal());
        result.setContent(list);
        return result;
    }

    @Override
    public SysUser findById(String id) {
        return sysUserMapper.selectById(id);
    }

    @Override
    public String login(SysUser user) {
        SysUser result = sysUserMapper.login(user);
        if (result != null) {
            return JwtUtil.createJwt(result.getUserName());
        }
        throw new RuntimeException("登录失败");
    }

    @Override
    public void save(SysUser user) {
        SysUser result = sysUserMapper.selectOne(new QueryWrapper<SysUser>()
                .eq("user_name", user.getUserName()));
        if (result != null) {
            throw new RuntimeException("用户名已存在");
        }
        user.setPassword(Md5Utils.getMD5(user.getPassword()));
        user.setId(UUIDUtil.creatUUID());
        sysUserMapper.insertSelective(user);
    }

    @Override
    public void update(SysUser user) {
        sysUserMapper.updateByIdSelective(user);
    }

    @Override
    public void deleteById(String id) {
        SysUser result = sysUserMapper.selectOne(new QueryWrapper<SysUser>().eq("id", id));
        if (result == null) {
            throw new RuntimeException("用户不存在");
        }
        sysUserMapper.deleteById(id);
    }
}
