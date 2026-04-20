package com.qk.management.mapper;

import com.qk.model.entity.Course;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author 33465
 * @created 2026/4/20 下午5:37
 * @desciption 课程管理数据层接口
 */

@Mapper
public interface CourseMapper {
    /**
     * 根据条件查询课程信息
     * @param name 课程名称
     * @param subject 课程学科
     * @param target 适用人群
     * @return 课程列表
     */
    List<Course> selectByCondition(String name, Integer subject, Integer target);

    /**
     * 根据id查询课程信息
     * @param id 课程id
     * @return 课程信息
     */
    Course selectById(Integer id);

    /**
     * 删除课程信息
     * @param id 课程id
     */
    void deleteById(Integer id);

    /**
     * 新增课程信息
     * @param course 课程信息
     */
    void insert(Course course);

    /**
     * 修改课程信息
     * @param course 课程信息
     */
    void updateById(Course course);

    /**
     * 查询所有课程信息
     * @return 课程信息
     */
    List<Course> selectAll();

    /**
     * 根据条件查询课程信息(名称精确)
     * @param name 课程名称
     * @param subject 课程学科
     * @param target 课程目标
     * @return 课程信息
     */
    List<Course> selectByConditionEnhanced(String name, Integer subject, Integer target);
}
