package com.tzzh.taskrwzl.service.base;

import com.tzzh.taskrwzl.util.ApiResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: PCJ
 * @Create: 2022-05-05 17:06
 * @Description:
 **/
@RestController
@RequestMapping("/base")
public class BaseController {

    @Autowired
    BaseService baseService;

    @PostMapping("/addBase")
    public ApiResult addBase(BaseDto baseDto){

        return ApiResult.ok();
    }


}
