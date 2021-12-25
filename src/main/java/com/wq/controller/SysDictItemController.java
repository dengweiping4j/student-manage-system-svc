package com.wq.controller;

import com.wq.entity.PageParam;
import com.wq.entity.ResultBody;
import com.wq.entity.SysDictItem;
import com.wq.service.SysDictItemService;
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
@RequestMapping("/system/dictItem")
@Api(tags = "系统字典项管理类")
public class SysDictItemController {
    @Autowired
    private SysDictItemService dictItemService;

    /**
     * 查询
     *
     * @param dict
     * @return
     */
    @ApiOperation(value = "find", notes = "查询", produces = "application/json")
    @ApiResponses({@ApiResponse(code = 200, message = "查询成功")})
    @PostMapping(value = "/find")
    public ResultBody find(@RequestBody SysDictItem dict) {
        return ResultBody.success(dictItemService.find(dict));
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
    public ResultBody save(@RequestBody SysDictItem dict) {
        dictItemService.save(dict);
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
    public ResultBody update(@RequestBody SysDictItem dict) {
        dictItemService.update(dict);
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
        dictItemService.deleteById(id);
        return ResultBody.success();
    }
}
