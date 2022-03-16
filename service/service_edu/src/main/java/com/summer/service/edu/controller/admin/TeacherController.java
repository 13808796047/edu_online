package com.summer.service.edu.controller.admin;


import com.summer.common.utils.result.R;
import com.summer.service.edu.service.TeacherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author Summer
 * @since 2022-03-16
 */
@Api(tags = "讲师管理")
@RestController
@RequestMapping("admin/edu/teacher")
public class TeacherController {
    // 注入service
    @Autowired
    private TeacherService teacherService;

    // 查询讲师表所有数据
    @ApiOperation(value = "所有讲师列表", notes = "所有讲师列表")
    @GetMapping
    public R index() {
        return R.ok().data("data", teacherService.list());
    }

    /**
     * 逻辑删除讲师的方法
     *
     * @param id
     * @return boolean
     */
    @ApiOperation(value = "根据ID删除讲师", notes = "根据ID删除讲师,逻辑删除")
    @DeleteMapping("{id}")
    public R destroy(@ApiParam(value = "讲师ID", required = true) @PathVariable String id) {
        return teacherService.removeById(id) ? R.ok().message("删除成功") : R.error().message("删除失败");
    }
}

