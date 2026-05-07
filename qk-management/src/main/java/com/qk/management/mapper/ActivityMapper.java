package com.qk.management.mapper;

import com.qk.model.dto.ActivityPage;
import com.qk.model.entity.Activity;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author 33465
 * @created 2026/4/28 下午9:15
 * @desciption
 */
@Mapper
public interface ActivityMapper {

    List<Activity> selectByPageCondition(ActivityPage pageDTO);

    @Delete("delete from activity where id = #{id}")
    void deleteById(Integer id);

    @Select("select * from activity where id = #{id}")
    Activity selectById(Integer id);

    @Select("select * from activity where name = #{name}")
    Activity selectByName(String name);

    void insert(Activity activity);

    void update(Activity activity);

    @Select("select * from activity where type = #{type}")
    List<Activity> selectByType(Integer type);
}
   