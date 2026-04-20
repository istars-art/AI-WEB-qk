package com.qk.management.controller;

import com.qk.common.PageResult;
import com.qk.common.Result;
import com.qk.management.service.CourseService;
import com.qk.model.dto.CoursePage;
import com.qk.model.dto.CourseSaveDTO;
import com.qk.model.dto.CourseUpdateDTO;
import com.qk.model.vo.CourseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 33465
 * @created 2026/4/20 下午5:33
 * @desciption 课程管理控制器
 */
@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping
    public Result getPage(CoursePage pageDTO) {
       PageResult<CourseVO> coursePageVOs =  courseService.getPage(pageDTO);
       return Result.success(coursePageVOs);
    }

    @DeleteMapping("/{id}")
    public Result deleteById(@PathVariable Integer id) {
        courseService.deleteById(id);
        return Result.success();
    }

    @PostMapping
    public Result save(@RequestBody CourseSaveDTO courseSaveDTO) {
        courseService.save(courseSaveDTO);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id){
        CourseVO courseVO = courseService.getById(id);
        return Result.success(courseVO);
    }

    @PutMapping
    public Result update(@RequestBody CourseUpdateDTO courseUpdateDTO){
        courseService.update(courseUpdateDTO);
        return Result.success();
    }

    @GetMapping("/list")
    public Result getAll(){
        List<CourseVO> list = courseService.getAll();
        return Result.success(list);
    }

    @GetMapping("/subject/{subject}")
    public Result getBySubject(@PathVariable Integer subject){
        List<CourseVO> list = courseService.getBySubject(subject);
        return Result.success(list);
    }

}
   