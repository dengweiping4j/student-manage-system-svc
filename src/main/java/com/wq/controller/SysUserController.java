package com.wq.controller;

import com.wq.entity.PageParam;
import com.wq.entity.ResultBody;
import com.wq.entity.SysUser;
import com.wq.service.SysUserService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author 邓卫平
 * @date 2021/12/18 11:30
 */
@RestController
@RequestMapping("/system/user")
@Api(tags = "系统用户管理")
public class SysUserController {
    @Autowired
    private SysUserService sysUserService;

    /**
     * 分页查询
     *
     * @param user
     * @return
     */
    @ApiOperation(value = "findAll", notes = "分页查询", produces = "application/json")
    @ApiResponses({@ApiResponse(code = 200, message = "查询成功")})
    @PostMapping(value = "/findAll")
    public ResultBody findAll(@RequestBody SysUser user, @Valid PageParam page) {
        return ResultBody.success(sysUserService.findAll(user, page));
    }

    /**
     * 登录
     *
     * @param user
     * @return
     */
    @ApiOperation(value = "login", notes = "登录")
    @ApiImplicitParam(name = "user", value = "用户参数", required = true, paramType = "query")
    @PostMapping(value = "/login")
    public ResultBody login(@RequestBody SysUser user) {
        String token = sysUserService.login(user);
        return ResultBody.success(token);
    }

    /**
     * 新增
     *
     * @param user
     * @return
     */
    @ApiOperation(value = "save", notes = "注册")
    @ApiImplicitParam(name = "user", value = "用户参数", required = true, paramType = "query")
    @PostMapping(value = "/save")
    public ResultBody save(@Valid @RequestBody SysUser user) {
        sysUserService.save(user);
        return ResultBody.success();
    }

    /**
     * 修改
     *
     * @param user
     * @return
     */
    @ApiOperation(value = "update", notes = "修改")
    @ApiImplicitParam(name = "user", value = "用户参数", required = true, paramType = "query")
    @PutMapping(value = "/update")
    public ResultBody update(@Valid @RequestBody SysUser user) {
        sysUserService.update(user);
        return ResultBody.success();
    }

    /**
     * 删除
     *
     * @param id
     * @return
     */
    @ApiOperation(value = "delete", notes = "删除")
    @ApiImplicitParam(name = "userName", value = "用户名", required = true, paramType = "path")
    @DeleteMapping(value = "/delete/{id}")
    public ResultBody register(@PathVariable String id) {
        sysUserService.deleteById(id);
        return ResultBody.success();
    }
}
