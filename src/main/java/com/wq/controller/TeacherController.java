package com.wq.controller;

import com.wq.entity.PageParam;
import com.wq.entity.ResultBody;
import com.wq.entity.TeacherInfo;
import com.wq.service.StudentService;
import com.wq.service.TeacherService;
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
@RequestMapping("/teacher")
@Api(tags = "教师信息管理")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    /**
     * 分页查询
     *
     * @param teacherInfo
     * @return
     */
    @ApiOperation(value = "findAll", notes = "分页查询", produces = "application/json")
    @ApiResponses({@ApiResponse(code = 200, message = "查询成功")})
    @PostMapping(value = "/findAll")
    public ResultBody findAll(@RequestBody TeacherInfo teacherInfo, @Valid PageParam page) {
        return ResultBody.success(teacherService.findAll(teacherInfo, page));
    }

    /**
     * 查询
     *
     * @param teacherInfo
     * @return
     */
    @ApiOperation(value = "find", notes = "查询", produces = "application/json")
    @ApiResponses({@ApiResponse(code = 200, message = "查询成功")})
    @PostMapping(value = "/find")
    public ResultBody find(@RequestBody TeacherInfo teacherInfo) {
        return ResultBody.success(teacherService.find(teacherInfo));
    }

    /**
     * 保存
     *
     * @param teacherInfo
     * @return
     */
    @ApiOperation(value = "save", notes = "保存", produces = "application/json")
    @ApiResponses({@ApiResponse(code = 200, message = "保存成功")})
    @PostMapping(value = "/save")
    public ResultBody save(@RequestBody TeacherInfo teacherInfo) {
        teacherService.save(teacherInfo);
        return ResultBody.success();
    }

    /**
     * 修改
     *
     * @param teacherInfo
     * @return
     */
    @ApiOperation(value = "update", notes = "修改", produces = "application/json")
    @ApiResponses({@ApiResponse(code = 200, message = "修改成功")})
    @PutMapping(value = "/update")
    public ResultBody update(@RequestBody TeacherInfo teacherInfo) {
        teacherService.update(teacherInfo);
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
        teacherService.deleteById(id);
        return ResultBody.success();
    }
}
