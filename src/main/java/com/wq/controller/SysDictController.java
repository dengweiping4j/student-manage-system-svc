package com.wq.controller;

import com.wq.entity.PageParam;
import com.wq.entity.ResultBody;
import com.wq.entity.SysDict;
import com.wq.entity.SysUser;
import com.wq.service.SysDictService;
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
@RequestMapping("/system/dict")
@Api(tags = "系统字典管理类")
public class SysDictController {
    @Autowired
    private SysDictService dictService;

    /**
     * 分页查询
     *
     * @param dict
     * @return
     */
    @ApiOperation(value = "findAll", notes = "分页查询", produces = "application/json")
    @ApiResponses({@ApiResponse(code = 200, message = "查询成功")})
    @PostMapping(value = "/findAll")
    public ResultBody findAll(@RequestBody SysDict dict, @Valid PageParam page) {
        return ResultBody.success(dictService.findAll(dict, page));
    }

    /**
     * 查询
     *
     * @param dict
     * @return
     */
    @ApiOperation(value = "find", notes = "查询", produces = "application/json")
    @ApiResponses({@ApiResponse(code = 200, message = "查询成功")})
    @PostMapping(value = "/find")
    public ResultBody find(@RequestBody SysDict dict) {
        return ResultBody.success(dictService.find(dict));
    }

    /**
     * 保存
     *
     * @param dict
     * @return
     */
    @ApiOperation(value = "save", notes = "保存", produces = "application/json")
    @ApiResponses({@ApiResponse(code = 200, message = "保存成功")})
    @PostMapping(value = "/save")
    public ResultBody save(@RequestBody SysDict dict) {
        dictService.save(dict);
        return ResultBody.success();
    }

    /**
     * 修改
     *
     * @param dict
     * @return
     */
    @ApiOperation(value = "update", notes = "修改", produces = "application/json")
    @ApiResponses({@ApiResponse(code = 200, message = "修改成功")})
    @PutMapping(value = "/update")
    public ResultBody update(@RequestBody SysDict dict) {
        dictService.update(dict);
        return ResultBody.success();
    }

    /**
     * 删除
     *
     * @param id
     * @return
     */
    @ApiOperation(value = "delete", notes = "删除")
    @DeleteMapping(value = "/delete/{id}")
    public ResultBody register(@PathVariable String id) {
        dictService.deleteById(id);
        return ResultBody.success();
    }
}
