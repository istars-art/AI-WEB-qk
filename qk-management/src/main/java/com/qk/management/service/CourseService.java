package com.qk.management.service;

import com.qk.common.PageResult;
import com.qk.model.dto.CoursePage;
import com.qk.model.dto.CourseSaveDTO;
import com.qk.model.dto.CourseUpdateDTO;
import com.qk.model.vo.CourseVO;

import java.util.List;

/**
 * @author 33465
 * @created 2026/4/20 下午5:34
 * @desciption 课程管理业务服务接口
 */

public interface CourseService {
    /**
     * 课程列表分页查询
     * @param pageDTO 分页参数
     * @return List<CourseVO>
     */
    PageResult<CourseVO> getPage(CoursePage pageDTO);

    /**
     * 根据id删除课程
     * @param id 课程id
     */
    void deleteById(Integer id);

    /**
     * 保存课程
     * @param courseSaveDTO 课程信息
     */
    void save(CourseSaveDTO courseSaveDTO);

    /**
     * 根据id查询课程信息
     * @param id 课程id
     * @return CourseVO
     */
    CourseVO getById(Integer id);

    /**
     * 更新课程信息
     * @param courseUpdateDTO 课程信息
     */
    void update(CourseUpdateDTO courseUpdateDTO);

    /**
     * 查询所有课程信息
     * @return List<CourseVO>
     */
    List<CourseVO> getAll();

    /**
     * 根据学科查询课程信息
     * @param subject 课程学科
     * @return List<CourseVO>
     */
    List<CourseVO> getBySubject(Integer subject);
}
