package com.qk.management.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qk.common.PageResult;
import com.qk.common.enums.QkBizExceptionInfoEnum;
import com.qk.common.exception.QkBizException;
import com.qk.management.mapper.CourseMapper;
import com.qk.management.service.CourseService;
import com.qk.model.dto.CoursePage;
import com.qk.model.dto.CourseSaveDTO;
import com.qk.model.dto.CourseUpdateDTO;
import com.qk.model.entity.Course;
import com.qk.model.vo.CourseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

/**
 * @author 33465
 * @created 2026/4/20 下午5:35
 * @desciption 课程管理业务服务实体类
 */
@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseMapper courseMapper;

    @Override
    public PageResult<CourseVO> getPage(CoursePage pageDTO) {
        List<Course> list = courseMapper.selectByCondition(pageDTO.getName(), pageDTO.getSubject(), pageDTO.getTarget());

        PageHelper.startPage(pageDTO.getPage(), pageDTO.getPageSize());
        PageInfo<Course> pageInfo = PageInfo.of(list);
        List<CourseVO> voList = list.stream()
                .map(course -> BeanUtil.copyProperties(course, CourseVO.class))
                .toList();
        return PageResult.<CourseVO>builder()
                .total(pageInfo.getTotal())
                .rows(voList)
                .build();
    }

    @Override
    public void deleteById(Integer id) {
        // 判断课程是否存在
        if (Objects.isNull(courseMapper.selectById(id))){
            throw new QkBizException(QkBizExceptionInfoEnum.COURSE_NOT_EXIST);
        }

        // 删除课程
        courseMapper.deleteById(id);
    }

    @Override
    public void save(CourseSaveDTO courseSaveDTO) {
        // 检验课程是否存在
        if (!courseMapper.selectByConditionEnhanced(courseSaveDTO.getName(), courseSaveDTO.getSubject(), courseSaveDTO.getTarget()).isEmpty()){
            throw new QkBizException(QkBizExceptionInfoEnum.COURSE_REPEAT);
        }

        Course course = BeanUtil.copyProperties(courseSaveDTO, Course.class);
        course.setCreateTime(LocalDateTime.now());
        course.setUpdateTime(LocalDateTime.now());
        courseMapper.insert(course);
    }

    @Override
    public CourseVO getById(Integer id) {

        // 检查id是否存在、是否为null(TODO 防前端)
        if (Objects.isNull(courseMapper.selectById(id))){
            throw new QkBizException(QkBizExceptionInfoEnum.COURSE_NOT_EXIST);
        }

        Course course = courseMapper.selectById(id);
        return BeanUtil.copyProperties(course, CourseVO.class);
    }

    @Override
    public void update(CourseUpdateDTO courseUpdateDTO) {
        // 检查id是否存在、是否为null(TODO 防前端)
        if (Objects.isNull(courseMapper.selectById(courseUpdateDTO.getId()))){
            throw new QkBizException(QkBizExceptionInfoEnum.COURSE_NOT_EXIST);
        }
        // 检查除dto.id外，课程名称是否重复
        List<Course> list = courseMapper.selectByCondition(courseUpdateDTO.getName(), courseUpdateDTO.getSubject(), courseUpdateDTO.getTarget());
        if (!list.isEmpty()){
            throw new QkBizException(QkBizExceptionInfoEnum.COURSE_REPEAT);
        }

        // TODO 执行更新操作
        Course course = BeanUtil.copyProperties(courseUpdateDTO, Course.class);
        course.setUpdateTime(LocalDateTime.now());
        courseMapper.updateById(course);
    }

    @Override
    public List<CourseVO> getAll() {
        List<Course> courseList = courseMapper.selectAll();

        return courseList.stream()
                .map(course -> BeanUtil.copyProperties(course, CourseVO.class))
                .toList();
    }

    @Override
    public List<CourseVO> getBySubject(Integer subject) {
        List<Course> courses = courseMapper.selectByCondition(null, subject, null);
        return courses.stream()
                .map(course -> BeanUtil.copyProperties(course, CourseVO.class))
                .toList();
    }

}
   