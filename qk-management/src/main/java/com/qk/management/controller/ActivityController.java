package com.qk.management.controller;

import com.qk.common.PageResult;
import com.qk.common.Result;
import com.qk.management.service.ActivityService;
import com.qk.model.dto.ActivityPage;
import com.qk.model.dto.ActivitySaveDTO;
import com.qk.model.dto.ActivityUpdateDTO;
import com.qk.model.vo.ActivityVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * @author 33465
 * @created 2026/4/28 下午9:14
 * @desciption
 */
@RestController
@RequestMapping("/activities")
public class ActivityController {

    @Autowired
    ActivityService activityService;

    @GetMapping
    public Result page(ActivityPage pageDTO){
        PageResult<ActivityVO> activitiesVO = activityService.page(pageDTO);

        return Result.success(activitiesVO);
    }

    @DeleteMapping("/{id}")
    public Result deleteById(@PathVariable Integer id){
        activityService.deleteById(id);
        return Result.success();
    }

    @PostMapping
    public Result save(@RequestBody ActivitySaveDTO saveDTO){
        activityService.save(saveDTO);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id){
        ActivityVO activityVO = activityService.getById(id);
        return Result.success(activityVO);
    }

    @PutMapping
    public Result update(@RequestBody ActivityUpdateDTO updateDTO){
        activityService.update(updateDTO);
        return Result.success();
    }

    @GetMapping("/{type}")
    public Result getByType(@PathVariable Integer type){
        List<ActivityVO> activityVOs = activityService.getByType(type);
        return Result.success(activityVOs);
    }
}
   