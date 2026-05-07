package com.qk.management.service;

import com.qk.common.PageResult;
import com.qk.model.dto.ActivityPage;
import com.qk.model.dto.ActivitySaveDTO;
import com.qk.model.dto.ActivityUpdateDTO;
import com.qk.model.vo.ActivityVO;

import java.util.List;

/**
 * @author 33465
 * @created 2026/4/28 下午9:14
 * @desciption
 */
public interface ActivityService {

    PageResult<ActivityVO> page(ActivityPage pageDTO);


    void deleteById(Integer id);

    void save(ActivitySaveDTO saveDTO);

    ActivityVO getById(Integer id);

    void update(ActivityUpdateDTO updateDTO);

    List<ActivityVO> getByType(Integer type);
}
   