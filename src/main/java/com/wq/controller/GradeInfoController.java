package com.wq.controller;

import com.wq.entity.ClassInfo;
import com.wq.entity.GradeInfo;
import com.wq.entity.PageParam;
import com.wq.entity.ResultBody;
import com.wq.service.ClassInfoService;
import com.wq.service.GradeInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author 邓卫平
 * @date 2022/01/02 12:30
 */
@RestController
@RequestMapping("/gradeInfo")
@Api(tags = "年级信息管理")
public class GradeInfoController {
    @Autowired
    private GradeInfoService gradeInfoService;

    /**
     * 分页查询
     *
     * @param gradeInfo
     * @return
     */
    @ApiOperation(value = "findAll", notes = "分页查询", produces = "application/json")
    @ApiResponses({@ApiResponse(code = 200, message = "查询成功")})
    @PostMapping(value = "/findAll")
    public ResultBody findAll(@RequestBody GradeInfo gradeInfo, @Valid PageParam page) {
        return ResultBody.success(gradeInfoService.findAll(gradeInfo, page));
    }

    /**
     * 查询
     *
     * @param gradeInfo
     * @return
     */
    @ApiOperation(value = "find", notes = "查询", produces = "application/json")
    @ApiResponses({@ApiResponse(code = 200, message = "查询成功")})
    @PostMapping(value = "/find")
    public ResultBody find(@RequestBody GradeInfo gradeInfo) {
        return ResultBody.success(gradeInfoService.find(gradeInfo));
    }

    /**
     * 保存
     *
     * @param gradeInfo
     * @return
     */
    @ApiOperation(value = "save", notes = "保存", produces = "application/json")
    @ApiResponses({@ApiResponse(code = 200, message = "保存成功")})
    @PostMapping(value = "/save")
    public ResultBody save(@RequestBody GradeInfo gradeInfo) {
        gradeInfoService.save(gradeInfo);
        return ResultBody.success();
    }

    /**
     * 修改
     *
     * @param gradeInfo
     * @return
     */
    @ApiOperation(value = "update", notes = "修改", produces = "application/json")
    @ApiResponses({@ApiResponse(code = 200, message = "修改成功")})
    @PutMapping(value = "/update")
    public ResultBody update(@RequestBody GradeInfo gradeInfo) {
        gradeInfoService.update(gradeInfo);
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
        gradeInfoService.deleteById(id);
        return ResultBody.success();
    }
}
