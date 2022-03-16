package com.summer.service.edu.controller;


import com.summer.service.edu.entity.Teacher;
import com.summer.service.edu.service.TeacherService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author Summer
 * @since 2022-03-16
 */
@RestController
@RequestMapping("service-edu/teacher")
public class TeacherController {
    // 注入service
    @Autowired
    private TeacherService teacherService;

    // 查询讲师表所有数据
    @GetMapping
    @ApiOperation("查询方法--index")
    public List<Teacher> index() {
        return teacherService.list(null);
    }

    /**
     * 逻辑删除讲师的方法
     *
     * @param id
     * @return boolean
     */
    @DeleteMapping("{id}")
    public boolean destroy(@PathVariable String id) {
        return teacherService.removeById(id);
    }
}

