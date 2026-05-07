package com.qk.management.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qk.common.PageResult;
import com.qk.common.enums.QkBizExceptionInfoEnum;
import com.qk.common.exception.QkBizException;
import com.qk.management.mapper.ActivityMapper;
import com.qk.management.service.ActivityService;
import com.qk.model.dto.ActivityPage;
import com.qk.model.dto.ActivitySaveDTO;
import com.qk.model.dto.ActivityUpdateDTO;
import com.qk.model.entity.Activity;
import com.qk.model.vo.ActivityVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

/**
 * @author 33465
 * @created 2026/4/28 下午9:15
 * @desciption
 */
@Service
public class ActivityServiceImpl implements ActivityService {

    @Autowired
    private ActivityMapper activityMapper;

    @Override
    public PageResult<ActivityVO> page(ActivityPage pageDTO) {
        PageHelper.startPage(pageDTO.getPage(), pageDTO.getPageSize());

        List<Activity> activities = activityMapper.selectByPageCondition(pageDTO);
        PageInfo<Activity> pageInfo = new PageInfo<>(activities);

        List<ActivityVO> activityVOs = activities.stream()
                .map(activity -> BeanUtil.copyProperties(activity, ActivityVO.class))
                .toList();

        return PageResult.<ActivityVO>builder()
                .total(pageInfo.getTotal())
                .rows(activityVOs)
                .build();
    }

    @Override
    public void deleteById(Integer id) {
        //校验活动是否处于进行中
        Activity activity = activityMapper.selectById(id);
        if (activity.getStartTime().isBefore(LocalDateTime.now()) && activity.getEndTime().isAfter(LocalDateTime.now())) {
            throw new QkBizException(QkBizExceptionInfoEnum.ACTIVITY_IS_IN_PROGRESS);
        }

        //删除活动业务
        activityMapper.deleteById(id);
    }

    @Override
    public void save(ActivitySaveDTO saveDTO) {
        //校验活动是否存在
        if (Objects.nonNull(activityMapper.selectByName(saveDTO.getName()))) {
            throw new QkBizException(QkBizExceptionInfoEnum.ACTIVITY_EXIST);
        }

        Activity activity = BeanUtil.copyProperties(saveDTO, Activity.class);
        activity.setCreateTime(LocalDateTime.now());
        activity.setUpdateTime(LocalDateTime.now());
        activityMapper.insert(activity);
    }

    @Override
    public ActivityVO getById(Integer id) {
        return BeanUtil.copyProperties(activityMapper.selectById(id), ActivityVO.class);
    }

    @Override
    public void update(ActivityUpdateDTO updateDTO) {
        //校验修改的名称是否存在
        if (Objects.nonNull(activityMapper.selectByName(updateDTO.getName())) && !activityMapper.selectById(updateDTO.getId()).getName().equals(updateDTO.getName())) {
            throw new QkBizException(QkBizExceptionInfoEnum.ACTIVITY_EXIST);
        }

        Activity activity = BeanUtil.copyProperties(updateDTO, Activity.class);
        activity.setUpdateTime(LocalDateTime.now());
        activityMapper.update(activity);
    }

    @Override
    public List<ActivityVO> getByType(Integer type) {
        List<Activity> activities = activityMapper.selectByType(type);

        return activities.stream()
                .map(activity -> BeanUtil.copyProperties(activity, ActivityVO.class))
                .toList();

    }
}
   