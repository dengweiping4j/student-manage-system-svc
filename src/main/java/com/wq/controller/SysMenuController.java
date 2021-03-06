package com.wq.controller;

import com.wq.entity.PageParam;
import com.wq.entity.ResultBody;
import com.wq.entity.SysMenu;
import com.wq.entity.SysRole;
import com.wq.service.SysMenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author 邓卫平
 * @date 2021/12/18 11:30
 */
@RestController
@RequestMapping("/system/menu")
@Api(tags = "系统菜单管理")
public class SysMenuController {
    @Autowired
    private SysMenuService menuService;

    /**
     * 分页查询
     *
     * @param menu
     * @return
     */
    @ApiOperation(value = "findAll", notes = "分页查询", produces = "application/json")
    @ApiResponses({@ApiResponse(code = 200, message = "查询成功")})
    @PostMapping(value = "/findAll")
    public ResultBody findAll(@RequestBody SysMenu menu, @Valid PageParam page) {
        return ResultBody.success(menuService.findAll(menu, page));
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
    public ResultBody find(@RequestBody SysMenu dict) {
        return ResultBody.success(menuService.find(dict));
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
    public ResultBody save(@RequestBody SysMenu dict) {
        menuService.save(dict);
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
    public ResultBody update(@RequestBody SysMenu dict) {
        menuService.update(dict);
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
        menuService.deleteById(id);
        return ResultBody.success();
    }
}
